package raihan.order.order.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produk {
    private Long id;
    private String nama;
    private String satuan;
    private double harga;

    // Getter manual agar tidak error di OrderService
    public Long getId() {
        return id;
    }
}