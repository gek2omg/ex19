package com.example.ex19.form;

import com.example.ex19.form.dto.FormCategory;
import com.example.ex19.form.dto.FormSaveDto;
import com.example.ex19.product.ProductCategoryListRepository;
import com.example.ex19.product.entity.ProductCategoryList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

@Service
@RequiredArgsConstructor
public class FormService {

    private final ProductCategoryListRepository productCategoryListRepository;

    @Transactional
    public void saveFormV1(FormSaveDto formSaveDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode jsonNode = mapper.readTree(formSaveDto.getSelectCategory());

//        JsonNode dataContent = jsonNode.get("");
//        for (JsonNode jsonDatum : dataContent) {
//            System.out.println(jsonDatum);
//        }

//        Iterator it = jsonNode.elements();
        for (JsonNode node : jsonNode) {
            ObjectMapper categoryMapper = new ObjectMapper();
            FormCategory formCategory = categoryMapper.treeToValue(node, FormCategory.class);

//            System.out.println(formCategory);
//            System.out.println(node);
//            System.out.println(node.get("cname1").asText());

            ProductCategoryList productCategoryList = new ProductCategoryList();

            int cid2 = Integer.parseInt(node.get("cid2").asText());

            productCategoryList.setProductId( 1 );
            productCategoryList.setCategoryId( cid2 );

            productCategoryListRepository.save(productCategoryList);

        }
    }


}
