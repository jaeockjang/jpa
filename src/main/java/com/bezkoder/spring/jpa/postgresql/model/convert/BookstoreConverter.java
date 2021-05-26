package com.bezkoder.spring.jpa.postgresql.model.convert;

import com.bezkoder.spring.jpa.postgresql.dto.BookstoreDTO;
import com.bezkoder.spring.jpa.postgresql.model.BookStore;
import org.springframework.beans.BeanUtils;

public class BookstoreConverter {

    public static BookstoreDTO convertDTO(BookStore bookStore) {

        if (bookStore == null) {
            return null;
        }

        BookstoreDTO bookstoreDTO = new BookstoreDTO();
        BeanUtils.copyProperties(bookStore,bookstoreDTO,"abc");

        return bookstoreDTO ;
    }



//
//    public static DeviceDTO convertDTO(GwDevice gwDevice, CommonCodeCacheService commonCodeCache) {
//        return convertDTO(gwDevice, gwDevice.getGpDeviceList(), commonCodeCache);
//    }
//
//    public static DeviceDTO convertDTO(GwDevice gwDevice, List<GwGpDevice> gwGpDeviceList, CommonCodeCacheService commonCodeCache) {
//        if (gwDevice == null) {
//            return null;
//        }
//
//        DeviceDTO deviceDTO = new DeviceDTO();
//
//        /** device status */
//        if (ObjectUtils.isNotEmpty(gwDevice.getGwDeviceStatus())) {
//            DeviceStatusDTO deviceStatusDTO = new DeviceStatusDTO();
//            BeanUtils.copyProperties(gwDevice.getGwDeviceStatus(),deviceStatusDTO,"gwDevice");
//            deviceDTO.setDeviceStatus(deviceStatusDTO);
//        }
//
//        deviceDTO.setDeviceId(gwDevice.getDeviceId());
//        deviceDTO.setDeviceName(gwDevice.getDeviceName());
//
//        if (gwDevice.getGwDeviceMd() != null) {
//            deviceDTO.setDeviceModel(DeviceModelConverter.transToDeviceModelDTO(gwDevice.getGwDeviceMd(), commonCodeCache));
//        }
//
//        if (gwDevice.getGwFw() != null) {
//            deviceDTO.setFirmware(FirmwareConverter.transToFirmwareDTO(gwDevice.getGwFw(), commonCodeCache));
//        }
//
//        deviceDTO.setDescription(gwDevice.getDeviceDesc());
//
//        if (gwDevice.getCreDt() != null) {
//            deviceDTO.setCreateDate(gwDevice.getCreDt().toString());
//        }
//
////		List<GwGpDevice> gwGpDeviceList = gwGpDeviceRepository.findByDeviceId(gwDevice.getDeviceId());
////		gwDevice.getGpDeviceList()
//
//        ArrayList<GroupDTO> groupDTOS = new ArrayList<>();
//        if (gwGpDeviceList != null && !gwGpDeviceList.isEmpty()) {
//
//            for (GwGpDevice gwGpDevice : gwGpDeviceList) {
//                if (gwGpDevice == null || gwGpDevice.getGwGp() == null || gwGpDevice.getGwGp().isDelYn()) {
//                    continue;
//                }
//
//                try {
//                    GroupDTO groupDTO = new GroupDTO();
//                    /** copy equipment spec properties to groupDTO */
//                    BeanUtils.copyProperties(gwGpDevice,groupDTO);
//
//                    /** for check position exists */
//                    deviceDTO.setPositionCode(gwGpDevice.getPosCd());
//                    if (StringUtils.isNotEmpty(gwGpDevice.getPosCd())) {
//                        deviceDTO.setPositionName(CommonCodeConverter.getCommonCodeValue( commonCodeCache.getCommonCodeDTO(gwGpDevice.getPosCd()) ));
//                    }
//
//                    /** set equipment id & name */
//                    if (ObjectUtils.isNotEmpty(gwGpDevice.getGwGp())) {
//                        deviceDTO.setEquipmentId(gwGpDevice.getGwGp().getGpId());
//                        deviceDTO.setEquipmentName(gwGpDevice.getGwGp().getGpName());
//                    }
//
//                    groupDTO.setTerminalCode(gwGpDevice.getGwGp().getTmlCd());
//                    if (StringUtils.isNotEmpty(gwGpDevice.getGwGp().getTmlCd())) {
//                        groupDTO.setTerminalName(CommonCodeConverter.getCommonCodeValue( commonCodeCache.getCommonCodeDTO(gwGpDevice.getGwGp().getTmlCd()) ));
//                    }
//
//                    groupDTO.setTypeCode(gwGpDevice.getGwGp().getTpCd());
//                    if (StringUtils.isNotEmpty(gwGpDevice.getGwGp().getTpCd())) {
//                        groupDTO.setTypeName(CommonCodeConverter.getCommonCodeValue( commonCodeCache.getCommonCodeDTO(gwGpDevice.getGwGp().getTpCd()) ));
//                    }
//
//                    groupDTO.setDescription(gwGpDevice.getGwGp().getGpDesc());
//
//                    if (StringUtils.isNotEmpty(gwGpDevice.getGwGp().getTmlCd())) {
//                        String terminalName=CommonCodeConverter.getCommonCodeValue( commonCodeCache.getCommonCodeDTO(gwGpDevice.getGwGp().getTmlCd()));
//                        groupDTO.setTerminalName(terminalName);
//                        /** set Terminal Code & Name to the Device Root */
//                        deviceDTO.setTerminalCode(gwGpDevice.getGwGp().getTmlCd());
//                        deviceDTO.setTerminalName(terminalName);
//                    }
//
//                    /** add Equipment Model */
//                    if (ObjectUtils.isNotEmpty(gwGpDevice.getGwGp().getGwEqMd())) {
//                        EquipmentModelDTO equipmentModelDTO =new EquipmentModelDTO();
//                        equipmentModelDTO.setEquipmentModelId(gwGpDevice.getGwGp().getGwEqMd().getEqMdId());
//                        equipmentModelDTO.setEquipmentModelName(gwGpDevice.getGwGp().getGwEqMd().getEqMdName());
//                        equipmentModelDTO.setDescription(gwGpDevice.getGwGp().getGwEqMd().getEqMdDesc());
//
//                        equipmentModelDTO.setTypeCode(gwGpDevice.getGwGp().getGwEqMd().getTpCd());
//                        if (StringUtils.isNotEmpty(gwGpDevice.getGwGp().getTpCd())) {
//                            equipmentModelDTO.setTypeName(CommonCodeConverter.getCommonCodeValue( commonCodeCache.getCommonCodeDTO(gwGpDevice.getGwGp().getTpCd()) ));
//                        }
//                        equipmentModelDTO.setBuiltYear(gwGpDevice.getGwGp().getGwEqMd().getBuiltYear());
//
//                        equipmentModelDTO.setManufactureCode(gwGpDevice.getGwGp().getGwEqMd().getMfCd());
//                        if (StringUtils.isNotEmpty(gwGpDevice.getGwGp().getGwEqMd().getMfCd())) {
//                            equipmentModelDTO.setManufactureName(CommonCodeConverter.getCommonCodeValue( commonCodeCache.getCommonCodeDTO(gwGpDevice.getGwGp().getGwEqMd().getMfCd())));
//                        }
//
//                        ArrayList<EquipmentModelPositionDTO> equipmentModelPositionDTOS = new ArrayList<>();
//                        if( ObjectUtils.isNotEmpty (gwGpDevice.getGwGp().getGwEqMd().getEqMdPos()) ) {
//                            gwGpDevice.getGwGp().getGwEqMd().getEqMdPos().forEach(eqMdPos -> {
//                                        EquipmentModelPositionDTO equipmentModelPositionDTO = new EquipmentModelPositionDTO();
//                                        equipmentModelPositionDTO.setPositionCode(eqMdPos.getPosCd());
//                                        equipmentModelPositionDTO.setPositionName(CommonCodeConverter.getCommonCodeValue(commonCodeCache.getCommonCodeDTO(eqMdPos.getPosCd())));
//                                        equipmentModelPositionDTOS.add(equipmentModelPositionDTO);
//                                    }
//                            );
//                        }
//                        equipmentModelDTO.setPosition(equipmentModelPositionDTOS);
//
//                        groupDTO.setEquipmentModel(equipmentModelDTO );
//                    }
//
//                    /** add Equipment & Device mapping list */
////					if (ObjectUtils.isNotEmpty(gwGpDevice.getGwDevice())) {
////						GroupDeviceDTO groupDeviceDTO = new GroupDeviceDTO();
////						groupDeviceDTO.setDevice();
////						gwGpDevice.getGwDevice()
////
////						gwGpDevice.getGwGp().getGpId()
////						gwGpDevice.getGwGp().getGpName()
////
////
////						ArrayList<GroupDeviceDTO> devices= new ArrayList<>();
////						devices.add(groupDeviceDTO);
////						groupDTO.setEquipmentDeviceList(devices);
////					}
//
////					if (!StringUtils.isEmpty(groupDTO.getTpCd())) {
////						deviceDTO.setEquipment(groupDTO);
////					} else {
////						deviceDTO.getGroupList().add(groupDTO);
////					}
//                    /** add equipment to list */
//                    groupDTOS.add(groupDTO);
//
//                } catch (Exception e) {
//                    log.error("Failed to retrieve the group list: ", e);
//                    return deviceDTO;
//                }
//            }
//        }
//        /** set group list */
////		deviceDTO.setGroupList(groupDTOS);
//
//        return deviceDTO;
//    }


}
