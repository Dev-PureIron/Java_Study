package domain;

import dao.MySalaryDAO;

public class MySalaryVO {
   private int salary; // 연봉
   private int netPay; // 실수령액
   private int taxDeductionAmount; // 공제액
   private int pension; // 국민연금
   private int healthInsurance; // 건강보험료
   private int longTermCarePay; // 장기요양료
   private int employmentInsurance; // 고용보험
   private int incomeTax; // 소득세
   private int localTax; // 지방소득세
   
   public MySalaryVO() {;}

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }

   public int getNetPay() {
      return netPay;
   }

   public void setNetPay(int netPay) {
      this.netPay = netPay;
   }

   public int getTaxDeductionAmount() {
      return taxDeductionAmount;
   }

   public void setTaxDeductionAmount(int taxDeductionAmount) {
      this.taxDeductionAmount = taxDeductionAmount;
   }

   public int getPension() {
      return pension;
   }

   public void setPension(int pension) {
      this.pension = pension;
   }

   public int getHealthInsurance() {
      return healthInsurance;
   }

   public void setHealthInsurance(int healthInsurance) {
      this.healthInsurance = healthInsurance;
   }

   public int getLongTermCarePay() {
      return longTermCarePay;
   }

   public void setLongTermCarePay(int longTermCarePay) {
      this.longTermCarePay = longTermCarePay;
   }

   public int getEmploymentInsurance() {
      return employmentInsurance;
   }

   public void setEmploymentInsurance(int employmentInsurance) {
      this.employmentInsurance = employmentInsurance;
   }

   public int getIncomeTax() {
      return incomeTax;
   }

   public void setIncomeTax(int incomeTax) {
      this.incomeTax = incomeTax;
   }

   public int getLocalTax() {
      return localTax;
   }

   public void setLocalTax(int localTax) {
      this.localTax = localTax;
   }

   @Override
   public String toString() {
      return MySalaryDAO.insertComma(salary) + "만원   " + MySalaryDAO.insertComma(netPay) + "   " + MySalaryDAO.insertComma(taxDeductionAmount) + "   " + MySalaryDAO.insertComma(pension)
            + "   " + MySalaryDAO.insertComma(healthInsurance) + "   " + MySalaryDAO.insertComma(longTermCarePay) + "   " + MySalaryDAO.insertComma(employmentInsurance)
            + "   " + MySalaryDAO.insertComma(incomeTax) + "   " + MySalaryDAO.insertComma(localTax);
   }
}














