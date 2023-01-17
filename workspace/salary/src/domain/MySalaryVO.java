package domain;

import dao.MySalaryDAO;

public class MySalaryVO {
   private int salary; // ����
   private int netPay; // �Ǽ��ɾ�
   private int taxDeductionAmount; // ������
   private int pension; // ���ο���
   private int healthInsurance; // �ǰ������
   private int longTermCarePay; // ������
   private int employmentInsurance; // ��뺸��
   private int incomeTax; // �ҵ漼
   private int localTax; // ����ҵ漼
   
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
      return MySalaryDAO.insertComma(salary) + "����   " + MySalaryDAO.insertComma(netPay) + "   " + MySalaryDAO.insertComma(taxDeductionAmount) + "   " + MySalaryDAO.insertComma(pension)
            + "   " + MySalaryDAO.insertComma(healthInsurance) + "   " + MySalaryDAO.insertComma(longTermCarePay) + "   " + MySalaryDAO.insertComma(employmentInsurance)
            + "   " + MySalaryDAO.insertComma(incomeTax) + "   " + MySalaryDAO.insertComma(localTax);
   }
}














