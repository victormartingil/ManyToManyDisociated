package com.app.jpa.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.app.jpa.converter.Converter;

public abstract class AbstractConverter<Entity, Dto> implements Converter<Entity, Dto> {

	@Override
	public Optional<Dto> convertEntityToDto(Optional<Entity> optional) {
		return optional.map(this::convertEntityToDto);
	}

	@Override
	public List<Dto> convertEntityToDto(List<Entity> list) {
		if (list == null) {
			return null;
		}
		return list.stream()
				   .map(this::convertEntityToDto)
				   .collect(Collectors.toList());
	}

	@Override
	public List<Entity> convertDtoToEntity(List<Dto> list) throws Exception {
		if (list == null) {
		    return null;
		}
		return list.stream()
				   .map(t -> {
					try {
						return convertDtoToEntity(t);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				})
				   .collect(Collectors.toList());
	}

}
