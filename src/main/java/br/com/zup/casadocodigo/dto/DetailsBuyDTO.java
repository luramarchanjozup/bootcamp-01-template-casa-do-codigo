package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.domain.Buyer;
import br.com.zup.casadocodigo.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DetailsBuyDTO {
    private final String name;
    private final String address;
    private final String complement;
    private final String city;
    private final String email;
    private final String phone;
    private final String zipCode;
    private final List<ReturnOrdemItensDTO> order;
    private final BigDecimal priceWithDescont;

    public DetailsBuyDTO(String name, String address, String complement, String city, String email, String phone, String zipCode, List<ReturnOrdemItensDTO> order, BigDecimal priceWithDescont) {
        this.name = name;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.zipCode = zipCode;
        this.order = order;
        this.priceWithDescont = priceWithDescont;
    }

    public static DetailsBuyDTO toModel (Buyer buyer, OrderRepository orderRepository) {
        var totalPrice = orderRepository.totalBuy(buyer.getOrder().getId());
        var discountPrice = buyer.totaldiscount(totalPrice);
        var orders = buyer.getOrder().getOrderItem().stream().map(ReturnOrdemItensDTO::converter).collect(Collectors.toList());

        return new DetailsBuyDTO (buyer.getName(), buyer.getAddress(), buyer.getComplement(),
                                            buyer.getCity(), buyer.getEmail(), buyer.getPhone(),
                                            buyer.getZipCode(), orders, discountPrice);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public List<ReturnOrdemItensDTO> getOrder() {
        return order;
    }

    public BigDecimal getPriceWithDescont() {
        return priceWithDescont;
    }
}
