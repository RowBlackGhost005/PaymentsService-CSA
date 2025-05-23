package com.marin.PaymentService.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.marin.PaymentService.entities.Payment;
import com.marin.PaymentService.service.PaymentService;
import jakarta.websocket.server.PathParam;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> registerPaymetn(@RequestBody Payment payment){
        Payment paymentDB = paymentService.registerPayment(payment);

        return ResponseEntity.ok(paymentDB);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> fetchAllPayments(){
        List<Payment> payments = paymentService.fetchAllPayments();

        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> fetchPaymentByOrderId(@PathVariable("id") int id){
        Payment payment = paymentService.fetchPaymentOrderId(id);

        return ResponseEntity.ok(payment);
    }

    @PutMapping("{id}")
    public ResponseEntity<Payment> updatePaymentStatus(@PathVariable("id") int id , @RequestBody JsonNode jsonNode){

        String status = jsonNode.get("status").asText();

        Payment paymentUpdated = paymentService.changePaymentStatusById(id , status);

        return ResponseEntity.ok(paymentUpdated);
    }
}
