package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.dto.BookstoreDTO;
import com.bezkoder.spring.jpa.postgresql.dto.GwPage;
import com.bezkoder.spring.jpa.postgresql.dto.PageParam;
import com.bezkoder.spring.jpa.postgresql.model.BookStore;
import com.bezkoder.spring.jpa.postgresql.model.convert.BookstoreConverter;
import com.bezkoder.spring.jpa.postgresql.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TestService {

    @Autowired
    private BookStoreRepository bookStoreRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LackRepository lackRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailRepository emailRepository;



    private Specification<BookStore> searchWith(PageParam pageParam) {

        return (Specification<BookStore>) ((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotEmpty(pageParam.getSearchText())) {
                List<Predicate> searchPredicates = new ArrayList<>();

                searchPredicates.add(builder.like(root.get("name"), "%" + pageParam.getSearchText() + "%"));
//                searchPredicates.add(builder.like(root.get("deviceDesc"), "%" + pageParam.getSearchText() + "%"));

                predicates.add(builder.or(searchPredicates.toArray(new Predicate[0])));
            }

            predicates.add(builder.isFalse((root.get("delYn"))));

            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }


    @Transactional(readOnly = true)
    public GwPage<BookstoreDTO> getDeviceList(PageParam pageParam) throws Exception {
        final PageRequest pageRequest = PageRequest.of(pageParam.getPage(), pageParam.getSize(),
                Sort.by("name").ascending().and(Sort.by("delYn").ascending()));

        Page<BookStore> enBookStore = null;
        GwPage<BookstoreDTO> gwPage = new GwPage<BookstoreDTO>();

        try {
            enBookStore = bookStoreRepository.findAll(this.searchWith(pageParam), pageRequest);

            if ( !enBookStore.isEmpty() ) {
                gwPage.setSize(pageParam.getSize());
                gwPage.setTotalElements(enBookStore.getTotalElements());
                gwPage.setTotalPages(enBookStore.getTotalPages());

                enBookStore.forEach(enBookstoreOne -> {
                    gwPage.addElement(BookstoreConverter.convertDTO(enBookstoreOne));
                });
            }

        } catch (Exception e) {
            log.error("Failed to retrieve the device list: ", e);
            throw e;
        }

        return gwPage;
    }


}
