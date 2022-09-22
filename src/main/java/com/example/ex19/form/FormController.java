package com.example.ex19.form;

import com.example.ex19.form.dto.FormCategory;
import com.example.ex19.form.dto.FormSaveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

@Controller
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;

    @GetMapping("/form/form")
    public String formMarket() {

        return "form";
    }


    @PostMapping("/form/form_proc")
    @ResponseBody
    public Result formMarketProc(FormSaveDto formSaveDto) throws JsonProcessingException {

        formService.saveFormV1(formSaveDto);

        return new Result(formSaveDto, "SUCCESS");
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
        private String msg;
    }
}
