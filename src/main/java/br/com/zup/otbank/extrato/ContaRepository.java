package br.com.zup.otbank.extrato;

import br.com.zup.otbank.extrato.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {
}
