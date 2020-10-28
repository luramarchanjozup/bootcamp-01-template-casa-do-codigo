package com.apicasadocodigo.casadocodigo.request;

import com.apicasadocodigo.casadocodigo.model.Book;
import com.apicasadocodigo.casadocodigo.model.Client;
import com.apicasadocodigo.casadocodigo.model.Coupon;
import com.apicasadocodigo.casadocodigo.model.purchase.Purchase;
import com.apicasadocodigo.casadocodigo.model.purchase.ShoppingCart;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseRequest {

    @Autowired  //1
    private GenericDAO genericDAO;

    @NotNull    //2
    private Client client;

               //3
    @NotNull
    @Valid /*usei o valid aqui porque porque o valor da compra não estava validando na PurchaseRequest
    (compra request) e tava estourando erro na hora de persistir e retornando 500. Usar o valid aqui
    faz retornar 400 */
    private ShoppingCart cart;

                //4
    private List<Book> books;

              //5
    private Coupon coupon;

    /*NOTA: criei esse construtor porque o jackson reclama quando há dois construtores
    (a compra pode ou não estar acompanhada de um cupom), pois nesse caso ele precisa
    de um construtor padrão junto de métodos getters e setters*/
    public PurchaseRequest() {

    }

            //6                 //7
    public Purchase toModel(GenericDAO genericDAO) {

        this.client = genericDAO.findEntityDepedenceDyId(Client.class, client.getId());

        this.books  = this.cart.getItems()
                .stream()
                    //8
                    .map(i -> genericDAO.findEntityDepedenceDyId(Book.class, i.getBookId()))
                .collect(Collectors.toList());

        //9
        if (coupon != null) {
            this.coupon = genericDAO.findEntityDepedenceDyId(Coupon.class, coupon.getId());
            return new Purchase(this.client, this.cart.getTotal(), this.books, this.coupon);
        }

        //o total calculado no servidor precisa ser igual ao total enviado
        BigDecimal totalOnServerSide = cart.getItems().stream()
                /*A partir dos items no objeto cart uso os ids de livros e faço uma busca no banco de dados.*/
                    .map(i -> genericDAO.findEntityDepedenceDyId(Book.class, i.getBookId()) //10
                /*Para cada livro encontrado é multiplicado seu preço pela quantia informada no objeto item*/
                    .getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                /*. Depois é realizada uma soma cumulativa para obter o valor calculado no servidor.*/
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));                       //11

        if(totalOnServerSide.compareTo(cart.getTotal()) != 0) //12
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor total enviado na requisição não corresponde ao valor calculado no servidor.");

        return new Purchase(this.client, this.cart.getTotal(), this.books);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    //PONTOS CDD: 12
}

