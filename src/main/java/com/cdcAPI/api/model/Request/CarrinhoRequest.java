package com.cdcAPI.api.model.Request;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class CarrinhoRequest {

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal total;

    @Size(min = 1)
    @Valid
    private List<CompraItemRequest> items;
    
    //get set
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<CompraItemRequest> getItems() {
        return items;
    }

    public void setItems(List<CompraItemRequest> items) {
        this.items = items;
    }
}
