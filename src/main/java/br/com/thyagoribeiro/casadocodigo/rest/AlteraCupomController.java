package br.com.thyagoribeiro.casadocodigo.rest;

import br.com.thyagoribeiro.casadocodigo.domain.Cupom;
import br.com.thyagoribeiro.casadocodigo.rest.contract.AlteraCupomRequest;
import br.com.thyagoribeiro.casadocodigo.utils.ErroPadronizado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

// CDD - Total 3

@RestController
public class AlteraCupomController {

    @PersistenceContext
    private EntityManager entityManager;

    @PatchMapping(value = "/api/cupom/{cupomId}")
    @Transactional
    public ResponseEntity<?> alteraCupom(@PathVariable Long cupomId, @RequestBody @Valid AlteraCupomRequest alteraCupomRequest) { // CDD 1 - Classe AlteraCupomRequest

        Cupom cupomAtualizavel = entityManager.find(Cupom.class, cupomId); // CDD 1 - Classe CupomValido
        if(cupomAtualizavel == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroPadronizado(Arrays.asList("CupomValido não encontrado"))); // CDD 1 - Classe ErroPadronizado

        Query query = entityManager.createQuery("SELECT c FROM CupomValido c WHERE codigo = :codigo");
        query.setParameter("codigo", alteraCupomRequest.getCodigo());
        List<Cupom> cupomCodigoList = query.getResultList(); // CDD 1 - Classe CupomValido

        if(cupomCodigoList.size() > 0 && cupomAtualizavel.getCodigo() != cupomCodigoList.get(0).getCodigo())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroPadronizado(Arrays.asList("Codigo já cadastrado em outro cupom")));

        cupomAtualizavel = alteraCupomRequest.toModel(cupomAtualizavel);
        entityManager.merge(cupomAtualizavel);

        return ResponseEntity.ok().body(alteraCupomRequest);
    }

}
