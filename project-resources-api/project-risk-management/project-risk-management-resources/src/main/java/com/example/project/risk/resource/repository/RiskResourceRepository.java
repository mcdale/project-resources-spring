package com.example.project.risk.resource.repository;

import com.example.project.risk.resource.RiskResource;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.links.PagedLinksInformation;
import io.katharsis.resource.list.ResourceListBase;
import io.katharsis.resource.meta.PagedMetaInformation;
import lombok.Data;


public interface RiskResourceRepository extends ResourceRepositoryV2<RiskResource, String> {
	
	@Data
	public class RiskResourceListMeta implements PagedMetaInformation {
		private Long totalResourceCount;
	}
	
	@Data
	public class RiskResourceListLinks implements PagedLinksInformation {
		private String first;
		private String prev;
		private String next;
		private String last;
	}
	
	public class RiskResourceList extends ResourceListBase<RiskResource,RiskResourceListMeta,RiskResourceListLinks> {
		
	}
	
	@Override
	public RiskResourceList findAll(QuerySpec querySpec);
}
