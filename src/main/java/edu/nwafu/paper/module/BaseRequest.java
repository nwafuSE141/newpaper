package edu.nwafu.paper.module;

import lombok.Data;

@Data
public class BaseRequest {

    private Integer type;

    private String difficult;

    private Integer courseId;

    private Integer pointId;

    private String question;

    private String answer;

    private String faq;

}
