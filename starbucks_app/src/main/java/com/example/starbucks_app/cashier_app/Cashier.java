package com.example.starbucks_app;




import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.validation.constrainted.Min;
import javax.validation.constrainted.NotNull;
import javax.validation.constrainted.Size;

@Entity
@Table(name = "created orders")
@Data
@RequiredArgsConstructor
class CashiersCommand {

	
     private @Id @GeneratedValue Long id;

        transient private String action ;
        private String firstname ;
        private String ordermame ;
        private String cardnum;
        private String phone ;
        private String account ;
        private String rewards ;

        private String orderNumber;
        private String transactionAmount;
        private String transactionCurrency;
        private String authId;
        private String authStatus;
        private String capturedId;
        private String captureStatus;

        public String firstname() { return firstname; }
        public String ordername() { return ordername; }
        public String cardnum() { return cardnum; }
        public String account() { return account; }
        public String rewards() { return rewards; }



    
}
