package implementPayroll;

import java.math.BigDecimal;

interface Payable{
	
	BigDecimal get_salary_to_pay();
}

class DailyEmployee implements Payable{
	BigDecimal hourly_rate;
	BigDecimal temp_salary;
	void get_time_card(){
		
	}

	public BigDecimal get_salary_to_pay(){
		return new BigDecimal("0");	}

}

class MonthlyEmployee implements Payable{
	BigDecimal flat_salary;
	BigDecimal commission_rate;
	BigDecimal temp_commission;
	void get_sales_receipt(){
		//to input sales amount 
	
		//commission*amt - run if get_sales_receipt
	}
	public BigDecimal get_salary_to_pay(){
		return new BigDecimal("0");
	}


}


interface UnionMembership{
	
	BigDecimal calculate_final_salary();

}

class MemberOfUnion implements UnionMembership{
	BigDecimal weekly_dues;
	BigDecimal service_charges;
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
	String employee_name;
	int employee_id;

	Payable p;
	UnionMembership u;

	MethodOfPayment m;

	void run_payroll(){
		
	}

}





public class Payroll{
	
	void execute_payroll(){

	}

	public static void main(String[] args) {
      System.out.println("Classes defined, functions not defined");
  



	}
}


class ManageData{


	void add_to_database(Employee emp){
		
	}

	Employee retrieve_from_database(){
		return null;
	}

	void modify_database(int empid){

	}


}



// create database employeepayroll;
// use employeepayroll;
// create table emp(name varchar(40), id int(10), isWeekly boolean, isMember boolean, hourlyRate BigDecimal, flatSalary BigDecimal, commissionRate BigDecimal, dues BigDecimal, serviceCharges BigDecimal, temp BigDecimal);


									



