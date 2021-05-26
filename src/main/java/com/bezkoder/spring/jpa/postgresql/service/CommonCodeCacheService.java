package com.bezkoder.spring.jpa.postgresql.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommonCodeCacheService {
//    @Autowired
//    private GwCommonRepository gwCommonRepository;
//
//    @Cacheable(cacheNames = CacheConfiguration.COMMON_CODE_CACHE, key = "#gwCommon.cd", unless = "#result == null")
//    public CommonCodeDTO transToCommonCodeDTO(GwCommon gwCommon) {
//        return CommonCodeConverter.convertToDto(gwCommon);
//    }
//
//    @Cacheable(cacheNames = CacheConfiguration.COMMON_CODE_CACHE, key = "#code", unless = "#result == null")
//    public CommonCodeDTO getCommonCodeDTO(String code) {
//        CommonCodeDTO dto = null;
//
//        Optional<GwCommon> gwCommonOptional = gwCommonRepository.findByCd(code);
//        GwCommon gwCommon = gwCommonOptional.orElse(null);
//
//        if( gwCommon != null ) {
//            dto = CommonCodeConverter.convertToDto(gwCommon);
//        }
//
//        return dto;
//    }
}
