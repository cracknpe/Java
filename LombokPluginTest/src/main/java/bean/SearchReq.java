package bean;

import lombok.Data;

@Data
public class SearchReq {
    private String searchParam;
    private int number;
    private boolean isValid;
}
