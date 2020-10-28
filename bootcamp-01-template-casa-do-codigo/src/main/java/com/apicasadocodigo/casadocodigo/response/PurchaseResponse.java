package com.apicasadocodigo.casadocodigo.response;

import com.apicasadocodigo.casadocodigo.model.purchase.Purchase;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseResponse {//detalhes da compra

    private String emailContact;

    private AddressDataForPurchaseDetails addressDataForPurchaseDetails;

    private BigDecimal total;
                    //1
    private List<BookDataForDetails> bookDataForDetailsList;

    private CouponResponse couponResponse;

                                //2
    public PurchaseResponse(Purchase purchase){
        this.emailContact = purchase.getClientEmailFromThisPurchase();
                                                                //3
        this.addressDataForPurchaseDetails = new AddressDataForPurchaseDetails(purchase.getAddressInfo());
        this.total = purchase.getTotal();

        bookDataForDetailsList = purchase.getBooks()
                .stream()   //4
                    .map(b -> new BookDataForDetails(b)).
                collect(Collectors.toList());


        if(purchase.getCoupon() != null)
            this.couponResponse = new CouponResponse(purchase.getCoupon());
    }

    public String getEmailContact(){
        return this.emailContact;
    }

    public AddressDataForPurchaseDetails getAddress(){
        return this.addressDataForPurchaseDetails;
    }

    public List<BookDataForDetails> getBooks() {
        return this.bookDataForDetailsList;
    }

    public CouponResponse getCoupon() {
        return couponResponse;
    }

    public String getTotal(){
        return String.format("R$ %s", this.total.toString());
    }

}