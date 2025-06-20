package org.taller.lambdas.supplier;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Supplier: no recibe ningun valor, pero retorna un resultado.
        Supplier<String> supplier = () -> "I am a supplier";
        String supplierValue = supplier.get();
        System.out.println(supplierValue);
    }
}
