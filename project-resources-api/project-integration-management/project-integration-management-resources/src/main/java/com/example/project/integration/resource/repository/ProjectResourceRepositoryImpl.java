package com.example.project.integration.resource.repository;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.common.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.integration.data.model.ProjectEntity;
import com.example.project.integration.data.repository.ProjectEntityRepository;
import com.example.project.integration.resource.ProjectResource;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;

@Component
public class ProjectResourceRepositoryImpl extends ResourceRepositoryBase<ProjectResource,String> implements ProjectResourceRepository {
	
	@Autowired
	private ProjectEntityRepository projects;
	
	public ProjectResourceRepositoryImpl() {
		super(ProjectResource.class);
	}

	@Override
	public ProjectResourceList findAll(QuerySpec querySpec) {
		
		ProjectResourceList list = new ProjectResourceList();
		ProjectResourceListMeta meta = new ProjectResourceListMeta();
		meta.setTotalResourceCount(projects.count());
		
		ProjectResourceListLinks links = new ProjectResourceListLinks();
		
		Iterable<ProjectEntity> entities = getAllEntities();
		
		Iterable<ProjectResource> resources = convert(entities);
		
		list.setMeta(meta);
		
		list.setLinks(links);
		
		querySpec.apply(resources, list);
		
		return list;
	}

	
	private Iterable<ProjectResource> convert(Iterable<ProjectEntity> entities) {
		
		Map<String, ProjectResource> resources = new HashMap<String, ProjectResource>();
		
		for(ProjectEntity entity: entities) {
			ProjectResource resource = new ProjectResource();
			resource.setId(entity.getIdentifier());
			resource.setLastChange(DateTimeUtils.formatInstant(entity.getUpdatedDate()));
			resource.setTitle(entity.getName());
			
			resources.put(resource.getId(), resource);
		}
		
		return resources.values();
	}

	private Iterable<ProjectEntity> getAllEntities() {
		return projects.findAll();
	}
}
