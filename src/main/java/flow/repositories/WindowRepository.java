package flow.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import flow.entities.Window;

public interface WindowRepository extends PagingAndSortingRepository<Window, Long> {

}
