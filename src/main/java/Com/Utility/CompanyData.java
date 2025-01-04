package Com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CompanyData {
	Properties pro;
	
	public CompanyData () {
		File add=new File("./TestData/test");
		try {
			FileInputStream fis=new FileInputStream(add);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String Browser() {
		String br=pro.getProperty("Browser");
		return br;
	}
	
	
	public String Logo() {
		String logo=pro.getProperty("logo");
		return logo;
	}
	public String BusinessName() {
		String businessname=pro.getProperty("BusinessName");
		return businessname;		
	}
	public String fname() {
		String fna=pro.getProperty("FirstName");
		return fna;		
	}
	public String lname() {
		String lna=pro.getProperty("LastName");
		return lna;		
	}
	public String email() {
		String mail=pro.getProperty("Email");
		return mail;		
	}
	public String phonenumber() {
		String number=pro.getProperty("Phone");
		return number;		
	}
	public String mobilenumber() {
		String mnumber=pro.getProperty("mobile");
		return mnumber;		
	}
	public String faxnumber() {
		String fax=pro.getProperty("Fax");
		return fax;		
	}
	public String website() {
		String web=pro.getProperty("Website");
		return web;		
	}
	public String street1() {
		String s1=pro.getProperty("Street1");
		return s1;		
	}
	public String street2() {
		String s2=pro.getProperty("Street2");
		return s2;		
	}
	public String city() {
		String cit=pro.getProperty("City");
		return cit;		
	}
	public String state() {
		String sta=pro.getProperty("State");
		return sta;		
	}
	public String pinn() {
		String pinnu=pro.getProperty("Pin");
		return pinnu;		
	}
	public String country() {
		String coun=pro.getProperty("Country");
		return coun;		
	}
	public String Gst() {
		String Gstin=pro.getProperty("GSTIN");
		return Gstin;		
	}
	public String RegisterNo() {
		String rn=pro.getProperty("Reg");
		return rn;		
	}
	public String Password() {
		String pass=pro.getProperty("password");
		return pass;		
	}
	public String taxname() {
		String Tax=pro.getProperty("taxName");
		return Tax;		
	}
	public String taxpercentag() {
		String percent=pro.getProperty("taxpercentage");
		return percent;		
	}
	public String namecurrency() {
		String cuu=pro.getProperty("currencyname");
		return cuu;		
	}
	public String AmountinRs() {
		String Rs=pro.getProperty("currencyinAmount");
		return Rs;		
	}
	public String Gtax() {
		String gtax=pro.getProperty("GrouptaxName");
		return gtax;		
	}
	public String subtile() {
		String subti=pro.getProperty("SubTitle");
		return subti;		
	}
	public String productname() {
		String pname=pro.getProperty("ProductName");
		return pname;		
	}
	public String PD() {
		String pd=pro.getProperty("ProductDiscription");
		return pd;		
	}
	public String quantity() {
		String qty=pro.getProperty("Qty");
		return qty;		
	}
	public String rate() {
		String ratep=pro.getProperty("Rate");
		return ratep;		
	}
	public String discount() {
		String Discount=pro.getProperty("Discount");
		return Discount;		
	}
	public String tasktname() {
		String tname=pro.getProperty("TaskName");
		return tname;		
	}
	public String TD() {
		String td=pro.getProperty("TaskDiscription");
		return td;		
	}
	public String tquantity() {
		String tqty=pro.getProperty("TaskQty");
		return tqty;		
	}
	public String trate() {
		String trate=pro.getProperty("TaskRate");
		return trate;		
	}
	public String tdiscount() {
		String tDiscount=pro.getProperty("TaskDiscount");
		return tDiscount;		
	}
	public String tandc() {
		String tandcon=pro.getProperty("TeamAndCondition");
		return tandcon;		
	}
	public String note() {
		String not=pro.getProperty("Note");
		return not;		
	}
	public String vendername() {
		String vender=pro.getProperty("VenderName");
		return vender;
	}
	public String Expensecat() {
		String category=pro.getProperty("Category");
		return category;
	}
	public String ExpenseAmount() {
		String Eamount=pro.getProperty("ExpenseAmount");
		return Eamount;
	}
	public String ShippingCost() {
		String shipCost=pro.getProperty("ShippingCost");
		return shipCost;
	}
	public String PaymentType() {
		String paytype=pro.getProperty("PaymentType");
		return paytype;
	}
	public String descriptiontype() {
		String descrip=pro.getProperty("Description");
		return descrip;
	}
	public String Ponumber() {
		String ponum=pro.getProperty("POnumber");
		return ponum;
	}
	public String InvoiceDeposite() {
		String invoiceDeposite=pro.getProperty("invoiceDeposite");
		return invoiceDeposite;
	}
	public String InvoiceDiscount() {
		String invoiceDiscount=pro.getProperty("invoiceDiscount");
		return invoiceDiscount;
	}
	public String fullpayment() {
		String fullpay=pro.getProperty("FullPayment");
		return fullpay;
	}
	public String partialPayment() {
		String Partial=pro.getProperty("PartialPayment");
		return Partial;
	}
	public String PartailAmount() {
		String pamount=pro.getProperty("PartialAmount");
		return pamount;
	}
	/*----------------------Login------------------------------*/
	
	public String Validid() {
		String id=pro.getProperty("ValidLooginID");
		return id;
	}
	public String validpass() {
		String pass=pro.getProperty("ValidPassword");
		return pass;
	}
	public String invalidid() {
		String id=pro.getProperty("InvalidId");
		return id;
	}
	public String invalidpass() {
		String pass=pro.getProperty("InvalidPassword");
		return pass;
	}
	/*----------------------PymentModule ------------------------------*/
	
	public String PaymentTypem() {
		String pay=pro.getProperty("PymentType");
		return pay;
	}
	public String PymentAmountm() {
		String amount=pro.getProperty("PymentAmount");
		return amount;
	}
	public String paymentNote() {
		String note=pro.getProperty("PymentNote");
		return note;
	}
	/*----------------------Product Module ------------------------------*/
	public String pnamem() {
		String pname=pro.getProperty("ProductNamep");
		return pname;
	}
	public String pcategortm() {
		String pcat=pro.getProperty("ProductCategory");
		return pcat;
	}
	public String Unittype() {
		String type=pro.getProperty("UniteType");
		return type;
	}
	public String pqtym() {
		String qty=pro.getProperty("PQtym");
		return qty;
	}
	public String buyprice() {
		String bprice=pro.getProperty("BuyPrice");
		return bprice;
	}
	public String salesprice() {
		String sprice=pro.getProperty("SalesPrice");
		return sprice;
	}
	public String productNote() {
		String note=pro.getProperty("ProductNote");
		return note;
	}
	/*----------------------Proforma Module ------------------------------*/

	public String profomaDis() {
		String note=pro.getProperty("profomadiscount");
		return note;
	}
	public String proshipping() {
		String note=pro.getProperty("proformashipping");
		return note;
	}

	/*----------------------Project Module ------------------------------*/
	public String Projectname() {
		String note=pro.getProperty("ProjectName");
		return note;
	}
	public String ProjectClient() {
		String note=pro.getProperty("Clientname");
		return note;
	}
	public String ProjectCost() {
		String note=pro.getProperty("ProjectCost");
		return note;
	}
	/*----------------------Task ------------------------------*/
	public String TaskName() {
		String note=pro.getProperty("ProjectTaskName");
		return note;
	}
	public String TaskPrice() {
		String note=pro.getProperty("ProjectTaskPrice");
		return note;
	}
	public String TaskTYpe() {
		String note=pro.getProperty("ProjectTaskType");
		return note;
	}
	public String proTaskqty() {
		String note=pro.getProperty("ProjectTaskQty");
		return note;
	}
	
	public String protaskNote() {
		String note=pro.getProperty("ProjectTaskNote");
		return note;
	}
	
	/*----------------------Sales Module ------------------------------*/
	public String SalespaymentType() {
		String note=pro.getProperty("SalePaymentType");
		return note;
	}
	/*----------------------GST3B ------------------------------*/
	
	public String BusinesGST() {
		String note=pro.getProperty("BusinessGST");
		return note;
	}
	public String GSTno() {
		String note=pro.getProperty("GSTNUMBER");
		return note;
	}
	
	
	
	
}
