package com.example.project.integration.resource.repository;

import com.example.project.integration.resource.ProjectResource;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.links.PagedLinksInformation;
import io.katharsis.resource.list.ResourceListBase;
import io.katharsis.resource.meta.PagedMetaInformation;
import lombok.Data;


public interface ProjectResourceRepository extends ResourceRepositoryV2<ProjectResource, String> {
	
	@Data
	public class ProjectResourceListMeta implements PagedMetaInformation {
		private Long totalResourceCount;
	}
	
	@Data
	public class ProjectResourceListLinks implements PagedLinksInformation {
		private String first;
		private String prev;
		private String next;
		private String last;
	}
	
	public class ProjectResourceList extends ResourceListBase<ProjectResource, ProjectResourceListMeta, ProjectResourceListLinks> {
		
	}
	
	@Override
	public ProjectResourceList findAll(QuerySpec querySpec);
}
