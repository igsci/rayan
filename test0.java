import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SupplyChainSystem {

    // Product Record
    static class ProductRecord {
        String productId;
        String productName;
        int productQuantity;
        BigDecimal productPrice;

        public ProductRecord(String productId, String productName, int productQuantity, BigDecimal productPrice) {
            this.productId = productId;
            this.productName = productName;
            this.productQuantity = productQuantity;
            this.productPrice = productPrice;
        }
    }

    // Warehouse Record
    static class WarehouseRecord {
        String warehouseId;
        String warehouseName;
        String warehouseLocation;

        public WarehouseRecord(String warehouseId, String warehouseName, String warehouseLocation) {
            this.warehouseId = warehouseId;
            this.warehouseName = warehouseName;
            this.warehouseLocation = warehouseLocation;
        }
    }

    // Order Record
    static class OrderRecord {
        String orderId;
        String productId;
        int orderQuantity;
        LocalDate orderDate;

        public OrderRecord(String orderId, String productId, int orderQuantity, LocalDate orderDate) {
            this.orderId = orderId;
            this.productId = productId;
            this.orderQuantity = orderQuantity;
            this.orderDate = orderDate;
        }
    }

    // Working-Storage Section
    ProductRecord[] productTable = new ProductRecord[100];
    WarehouseRecord[] warehouseTable = new WarehouseRecord[10];
    OrderRecord[] orderTable = new OrderRecord[1000];

    BigDecimal transformationFactor = new BigDecimal("1.10");
    BigDecimal totalOrderAmount = BigDecimal.ZERO;
    int countOrders = 0;

    String wsDateString;
    LocalDate wsDate;
    LocalTime wsTime;
    int wsDay;
    int wsMonth;
    int wsYear;
    int wsHour;
    int wsMinute;
    int wsSecond;

    int wsErrorCode = 0;
    String wsErrorMessage;
    int wsExitCode = 0;
    String wsFileStatus;

    char wsEof = 'N';
    char wsInvalidQuantity = 'N';
    char wsInvalidDate = 'N';

    LocalDate wsOrderDate;
    BigDecimal wsOrderAmount;

    int wsWarehouseIndex;
    int wsProductIndex;
    int wsOrderIndex;

    String wsReportLine;

    // Group Variable for Current Date
    static class CurrentDate {
        int wsCurrentYear;
        int wsCurrentMonth;
        int wsCurrentDay;
    }
    CurrentDate wsCurrentDate = new CurrentDate();

    // Group Variables for Start and End Dates
    static class PeriodDate {
        int wsYear;
        int wsMonth;
        int wsDay;
    }
    PeriodDate wsStartDate = new PeriodDate();
    PeriodDate wsEndDate = new PeriodDate();

    String wsReportDate;
    String wsReportTime;
    String wsReportFileName;

    BigDecimal wsOrderTotal;

    String wsQuantityString;
    int wsOrderQuantity;
    String wsQuantityDisplay;

    String wsTempProductId;
    String wsTempWarehouseId;

    char wsWarehouseFound = 'N';
    char wsProductFound = 'N';
    char wsInvalidAmount = 'N';

    int wsWarehouseIndex2;
    int wsProductIndex2;
    int wsOrderIndex2;
    int wsWarehouseIndex3;
    int wsProductIndex3;
    int wsOrderIndex3;

    int wsProductQuantity;
    BigDecimal wsProductPrice;
    BigDecimal wsOrderAmount3;
    int wsAccQuantity = 0;
    BigDecimal wsAccPrice = BigDecimal.ZERO;
    BigDecimal wsAccTotal = BigDecimal.ZERO;

    int wsOrderQuantity3;

    String wsStartDtString;
    String wsEndDtString;

    int wsReportLineCount;

    // Spaces for Formatting (example - you can extend as needed)
    String wsSpace = " ";
    String wsSpace2 = "  ";
    String wsSpace4 = "    "; 
    // ... and so on

    // Method to get the current date and time
    public void getCurrentDateTime() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        wsCurrentDate.wsCurrentYear = currentDate.getYear();
        wsCurrentDate.wsCurrentMonth = currentDate.getMonthValue();
        wsCurrentDate.wsCurrentDay = currentDate.getDayOfMonth();

        wsHour = currentTime.getHour();
        wsMinute = currentTime.getMinute();
        wsSecond = currentTime.getSecond();

        // Format date and time for reporting
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        wsReportDate = currentDate.format(dateFormatter);
        wsReportTime = currentTime.format(timeFormatter);
    }

    // ... other methods to be implemented based on the PROCEDURE DIVISION 
    // (which is not provided in your description) 
}