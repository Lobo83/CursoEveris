package org.cursoEveris.patrones.business.mapper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.cursoEveris.patrones.business.mapper.annotation.MappingId;

public class Mapper<T, O> {

	Class<T> vo;
	Class<O> entidad;
	public Mapper(Class<T> vo, Class<O> entidad){
		this.vo=vo;
		this.entidad=entidad;
	}
	
	public O mapVO2Entidad(T vo) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException{
		O resultado=(O) this.entidad.newInstance();
		Map<String,Method> getters = findGetterAndSetters(this.vo,Boolean.TRUE);
		Map<String,Method> setters =findGetterAndSetters(this.entidad,Boolean.FALSE);
		Set<String> mappingIds = getters.keySet();//getter y setter generan el mismo keyset
		for(String id:mappingIds){
			Method getter = getters.get(id);
			Method setter = setters.get(id);
			setter.invoke(resultado, getter.invoke(vo));
		}
		return resultado;
	}
	
	public T mapEntidad2VO( O entidad) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException{
		T resultado=(T) this.vo.newInstance();
		Map<String,Method> getters = findGetterAndSetters(this.entidad,Boolean.TRUE);
		Map<String,Method> setters =findGetterAndSetters(this.vo,Boolean.FALSE);
		Set<String> mappingIds = getters.keySet();//getter y setter generan el mismo keyset
		for(String id:mappingIds){
			Method getter = getters.get(id);
			Method setter = setters.get(id);
			setter.invoke(resultado, getter.invoke(entidad));
		}
		return resultado;
	}
	
	private Map<String,Method> findGetterAndSetters(Class<?> clase, Boolean getGetter) throws IntrospectionException{
		Map<String,Method> result = new HashMap<>();
		for (Field f: clase.getDeclaredFields()) {
			if(f.isAnnotationPresent(MappingId.class)){
				PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clase);
				if(getGetter){
					result.put(f.getAnnotation(MappingId.class).id(), pd.getReadMethod());
				}else{
					result.put(f.getAnnotation(MappingId.class).id(), pd.getWriteMethod());
				}
				
			}
		}
		return result;
	}
}
