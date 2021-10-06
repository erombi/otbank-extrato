package br.com.zup.otbank.extrato.consumer;

import br.com.zup.otbank.extrato.ContaRepository;
import br.com.zup.otbank.extrato.request.NovaTransacaoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TransacaoConsumer {

    @Autowired
    private ContaRepository repository;

    private final Logger logger = LoggerFactory.getLogger(TransacaoConsumer.class);

    @KafkaListener(topics = "transacoes", containerFactory = "kafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload NovaTransacaoRequest dto) {
        var conta = dto.toModel();

        repository.save(conta);
    }
}