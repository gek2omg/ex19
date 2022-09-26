package com.example.ex19.product;

import com.example.ex19.product.dto.ProductCategoryListDto;
import com.example.ex19.product.dto.ProductSaveDto;
import com.example.ex19.product.entity.Product;
import com.example.ex19.product.entity.ProductCategoryList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryListRepository productCategoryListRepository;

    @Transactional
    public int saveProductV1(ProductSaveDto productSaveDto) throws JsonProcessingException {

        Product product = Product.builder()
                .name(productSaveDto.getName())
                .price(productSaveDto.getPrice())
                .build();

        // 상품저장
        productRepository.save( product );
        // 저장된 상품의 id 값 얻기
        int product_id = product.getId();

        // JSON 읽기
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode jsonNode = mapper.readTree( productSaveDto.getSelectCategory() );

        // 상품 카테고리는 다중이며, 반복문으로 저장
        for (JsonNode node : jsonNode) {
            ObjectMapper categoryMapper = new ObjectMapper();
//            ProductCategoryListDto productCategoryListDto = categoryMapper.treeToValue(node, ProductCategoryListDto.class);

            // "value" 로 나오는 값을 " 없이 받기 asText()
            int cid2 = Integer.parseInt(node.get("cid2").asText());

            ProductCategoryList productCategoryList = ProductCategoryList.builder()
                    .productId( product_id )
                    .categoryId( cid2 )
                    .build();

            productCategoryListRepository.save(productCategoryList);

        }

        return product.getId();
        // 카테고리 저장

    }
}
