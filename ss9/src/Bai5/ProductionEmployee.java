package Bai5;

public class ProductionEmployee extends Employee {
    private int numOfProducts;
    private long price; // đơn giá 1 sản phẩm

    public ProductionEmployee(String name, int numOfProducts, long price) {
        super(name);
        this.numOfProducts = numOfProducts;
        this.price = price;
    }

    @Override
    public long calculateSalary() {
        return (long) numOfProducts * price;
    }

    @Override
    public String getType() {
        return "Production";
    }

    @Override
    public String getSalaryDetail() {
        return String.format(" (%d sản phẩm * %s)", numOfProducts, FormatUtils.money(price));
    }
}

