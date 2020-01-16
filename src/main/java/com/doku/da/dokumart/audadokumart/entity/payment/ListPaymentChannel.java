package com.doku.da.dokumart.audadokumart.entity.payment;

import com.doku.da.dokumart.audadokumart.entity.APInvoice;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity(name = "payment_channel")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ListPaymentChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nama;

    @OneToMany(mappedBy = "listPaymentChannel")
    private List<APInvoice> apInvoice;
}
