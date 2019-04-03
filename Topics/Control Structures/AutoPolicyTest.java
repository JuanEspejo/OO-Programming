// Fig. 5.12: AutoPolicyTest.java
// Demonstrating Strings in switch.

public class AutoPolicyTest
{
   public static void main(String[] args)
   {
      // create two AutoPolicy objects
      AutoPolicy policy1 = 
         new AutoPolicy(11111111, "Toyota Camry", "NJ");
      AutoPolicy policy2 = 
         new AutoPolicy(22222222, "Ford Fusion", "ME");

      // display whether each policy is in a no-fault state
      policyInNoFaultState(policy1);
      policyInNoFaultState(policy2);
   }

   // method that displays whether an AutoPolicy 
   // is in a state with no-fault auto insurance 
   public static void policyInNoFaultState(AutoPolicy policy)
   {
      System.out.println("The auto policy:");
      System.out.printf(
         "Account #: %d; Car: %s;%nState %s %s a no-fault state%n%n", 
         policy.getAccountNumber(), policy.getMakeAndModel(), 
         policy.getState(), 
         (policy.isNoFaultState() ? "is": "is not"));
   } 
} // end class AutoPolicyTest


class AutoPolicy
{
   private int accountNumber; // policy account number
   private String makeAndModel; // car that the policy applies to
   private String state; // two-letter state abbreviation

   // constructor
   public AutoPolicy(int accountNumber, String makeAndModel, String state)
   {
      this.accountNumber = accountNumber;
      this.makeAndModel = makeAndModel;
      this.state = state;
   }

   // sets the accountNumber
   public void setAccountNumber(int accountNumber)
   {
      this.accountNumber = accountNumber;
   }

   // returns the accountNumber
   public int getAccountNumber()
   {
      return accountNumber;
   } 

   // sets the makeAndModel
   public void setMakeAndModel(String makeAndModel)
   {
      this.makeAndModel = makeAndModel;
   }

   // returns the makeAndModel
   public String getMakeAndModel()
   {
      return makeAndModel;
   } 

   // sets the state
   public void setState(String state)
   {
      this.state = state;
   }

   // returns the state
   public String getState()
   {
      return state;
   }

   // predicate method returns whether the state has no-fault insurance
   public boolean isNoFaultState()
   {
      // determine whether state has no-fault auto insurance
      switch (getState()) {
         case "MA": case "NJ": case "NY": case "PA":
            return true;
         default:
            return false;
      }
   }
}


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
