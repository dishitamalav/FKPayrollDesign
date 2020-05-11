package implementPayroll;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

interface Payable{
	
	BigDecimal get_salary_to_pay();

	default void get_sales_receipt(double sale){
		System.out.println("Not valid");
	}
	

	default void get_time_card(int hours){
		System.out.println("Not valid");
	}
}

class DailyEmployee implements Payable{
	DailyEmployee(double hourly_rate){
		String s=String.valueOf(hourly_rate); 
		this.hourly_rate = new BigDecimal(s);
		temp_salary= new BigDecimal("0");
	}
	private BigDecimal hourly_rate;
	private BigDecimal temp_salary;
	public void get_time_card(int hours){
		String s=String.valueOf(hours); 
		BigDecimal h = new BigDecimal(s);
		if(hours>8)
		{
			BigDecimal eight = new BigDecimal("8");
			BigDecimal temp = new BigDecimal("1.5");
			BigDecimal t = h.subtract(eight);
			BigDecimal t1 = t.multiply(temp.multiply(hourly_rate));
			BigDecimal t2 = eight.multiply(hourly_rate);
			temp_salary = temp_salary.add(t1.add(t2));
		}
		else
		{
			temp_salary= temp_salary.add(h.multiply(hourly_rate));
		}
		
	}

	public BigDecimal get_salary_to_pay(){
		return new BigDecimal("0");	}

}




class MonthlyEmployee implements Payable{
	MonthlyEmployee(double flat_salary,double commission_rate){
		String s=String.valueOf(flat_salary); 
		this.flat_salary = new BigDecimal(s);
		s=String.valueOf(commission_rate); 
		this.commission_rate = new BigDecimal(s);
		temp_commission = new BigDecimal("0");
	}
	private BigDecimal flat_salary;
	private BigDecimal commission_rate;
	private BigDecimal temp_commission;
	public void get_sales_receipt(double sale){
		String s =String.valueOf(sale); 
		BigDecimal amt = new BigDecimal(s);
		temp_commission = temp_commission.add(amt.multiply(commission_rate));
	}



	public BigDecimal get_salary_to_pay(){
		return new BigDecimal("0");
	}


}


interface UnionMembership{
	
	BigDecimal calculate_final_salary();

}

class MemberOfUnion implements UnionMembership{
	MemberOfUnion(double weekly_dues){
		String s=String.valueOf(weekly_dues); 
		this.weekly_dues = new BigDecimal(s);
		service_charges = new BigDecimal("0");
		extra_dues = new BigDecimal("0");
		
	}
	private BigDecimal weekly_dues;
	private BigDecimal extra_dues;
	private BigDecimal service_charges;

	BigDecimal get_extra_dues(){
		return extra_dues;
	}
	void set_extra_dues(BigDecimal ed){
		extra_dues = ed;
	}
	public BigDecimal calculate_final_salary(){
		return new BigDecimal("0");
	}

}

class NotMemberOfUnion implements UnionMembership{
	public BigDecimal calculate_final_salary(){
		return new BigDecimal("0");
	}
}



interface MethodOfPayment{
	// Bigdecimal salary(Payable p, UnionMembership u){
	// 	BigDecimal first_caluclation = p.get_salary_to_pay()
	// }
	void pay(BigDecimal amount);
}

class Mail implements MethodOfPayment{
	public void pay(BigDecimal amount){
		System.out.println("Mailed Rs "+amount+" to registered postal address");
	}
}

class Paymaster implements MethodOfPayment{
	public void pay(BigDecimal amount){
		System.out.println("Rs "+amount+" is held by postmaster for collection");
	}
}

class BankAccount implements MethodOfPayment{
	public void pay(BigDecimal amount){
		System.out.println("Transferred Rs "+amount+" to registered bank account");
	}
}


class Employee{
	Employee(String employee_name,int employee_id){
		this.employee_name = employee_name;
		this.employee_id = employee_id;
			}
	String employee_name;
	
	int employee_id;
	Calendar last_paid;
	Payable p;
	UnionMembership u;
	MethodOfPayment m;

	// void run_payroll(){
		
	// }

}





public class Payroll{
	
	void add_employee(ManageData db){
		
		Scanner in = new Scanner(System.in);
  		System.out.println("Employee name:");
  		String name = in.nextLine();
  		System.out.println("Employee id:");
  		int id = in.nextInt();
  		Employee to_add = new Employee(name,id);
  		System.out.println("Does employee work on an hourly/monthly basis?(0 for houtly, 1 for monthly");
  		int hm = in.nextInt();
  		if(hm==0)
  		{
  			
  			System.out.println("Enter hourly rate for employee");
  			double hr = in.nextDouble();
  			DailyEmployee de = new DailyEmployee(hr);
  			to_add.p = de;

  		}
  		else
  		{
  			System.out.println("Enter flat salary for employee");
  			double fs = in.nextDouble();
  			//System.out.println(fs);
  			System.out.println("Enter commission rate for employee");
  			double cr = in.nextDouble();
  			//System.out.println(cr);
  			MonthlyEmployee me = new MonthlyEmployee(fs,cr);
  			to_add.p = me;

  		}
  		System.out.println("Does employee wish to be part of the union?(y/n)");
  		in.nextLine();

  		String ans = in.nextLine();
  		//System.out.println(ans);
  		if(ans.equals("y"))
  		{
  			System.out.println("Enter weekly dues");
  			double wd = in.nextDouble();
  			in.nextLine();

  			MemberOfUnion mu = new MemberOfUnion(wd);
  			to_add.u = mu;

  		}
  		else
  		{
  			NotMemberOfUnion nu = new NotMemberOfUnion();
  			to_add.u = nu;

  		}

  		System.out.println("Enter preferred mode of salary payment(mail/paymaster/bank account");
  		  		String mode = in.nextLine();
  		//System.out.println(mode);
  		//in.close()
  		if(mode.equals("mail"))
  		{
  			Mail m = new Mail();
  			to_add.m = m;
  		}
  		else if(mode.equals("paymaster"))
  		{
  			Paymaster p = new Paymaster();
  			to_add.m = p;
  		}
  		else
  		{
  			to_add.m = new BankAccount();
  		}
  		to_add.last_paid = Calendar.getInstance();

  		db.add_to_database(to_add);
  		System.out.println("Employee details added to database");

	}

	 void delete_employee(ManageData db){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter employee id of the employee whose record has to be deleted");	
		
		int id = in.nextInt();
		Employee x = db.retrieve_from_database(id);
		db.data.remove(x);
		System.out.println("Employee "+id+" deleted");
	}

	void post_time_card(ManageData db){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id = in.nextInt();
		System.out.println("Enter number of hours worked today");
		int hours = in.nextInt();
		Employee e = db.retrieve_from_database(id);
		DailyEmployee d = (DailyEmployee) e.p ;
		d.get_time_card(hours);
		System.out.println("Time card registered");
	}

	void post_sales_receipt(ManageData db){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id = in.nextInt();
		System.out.println("Enter amount of sale");
		double sale = in.nextDouble();
		Employee e = db.retrieve_from_database(id);
		MonthlyEmployee m = (MonthlyEmployee) e.p ;
		m.get_sales_receipt(sale);
		System.out.println("Sales receipt registered");

	}

	void post_charges(ManageData db){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Employee id to be charged");
		int id = in.nextInt();
		System.out.println("Enter amount to be charged");
		double amt = in.nextDouble();
		Employee e = db.retrieve_from_database(id);
		MemberOfUnion m = (MemberOfUnion) e.u;
		String s=String.valueOf(amt); 
		BigDecimal amount = new BigDecimal(s);
		BigDecimal temp = m.get_extra_dues();
		temp = temp.add(amount);
		m.set_extra_dues(temp);
		System.out.println("Employee "+ id + " charged by union");
	}



	void execute_payroll(){
		 
	}

	public static void main(String[] args) {
      //System.out.println("Classes defined, functions not defined");
  		Payroll pr = new Payroll();
  		ManageData db = new ManageData();
  		System.out.println("Database initialised");

  		
  		

  		// ArrayList<Employee> al = db.data;
  		// for(Employee e : al)
  		// {
  		// 	int day = e.last_paid.get(Calendar.DAY_OF_WEEK);
  		// 	System.out.println(day);
  		// }
  		Scanner in = new Scanner(System.in);
  		System.out.println("SELECT AN OPTION:");
  		System.out.println("1. Add a new employee");
  		System.out.println("2. Delete an employee record");
  		System.out.println("3. Post a time card");
  		System.out.println("4. Post a sales receipt");
  		System.out.println("5. Post a union membership/service charge");

  		int choice = in.nextInt();
  		//in.close();

  		switch(choice){
  			case 1: pr.add_employee(db);
  				break;
  			case 2: pr.delete_employee(db);
  				break;
  			case 3: pr.post_time_card(db);
  				break;
  			case 4: pr.post_sales_receipt(db);
  				break;
  			case 5: pr.post_charges(db);
  				break;

  			default: System.out.println("Option not valid, exiting");
  		}

  		
  		


  		}
}






