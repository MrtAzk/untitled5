package DAO.Constants;

public class SqlScriptConst {
    public static final String customerSaveScript= """
            INSERT INTO customer(name,email,password) VALUES(?,?,?)
            """;
    public static String customerFindById =  """
                SELECT * FROM customer
                WHERE id = ?
                """;

    public static String customerFindAll = """
            SELECT * FROM customer
            """;

    public static String customerExitsByEmail= """
            SELECT * FROM customer
                WHERE email = ?
            """;

    public static final String paymentSave = """
            INSERT INTO payment (order_id,payment_method,amount)
            VALUES(?,?,?)
            """;

    public static final String orderSave= """
            INSERT INTO "order" (customer_id,order_date,total_amount,)
            VALUES(?,?,?)
            """;

    public final static String productseacrhByName = """
            SELECT * FROM product  WHERE name LIKE ?
            """;
}
