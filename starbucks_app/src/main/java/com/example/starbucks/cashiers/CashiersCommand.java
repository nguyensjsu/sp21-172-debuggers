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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="orders")
@Data
@RequiredArgsConstructor
class CashiersCommand {

	private @Id @GeneratedValue Long id;



    private String name ;
    private String size ;
    private String milk;
    private String total;
    private String drink;




    public String name() {return name;}
    public String milk() {return milk; }
    public String total() {return total;}
    public String name() {return name;}



}
