<jsp:include page="customer-toptemplate.jsp" />
<p> Welcome Guest! </p>
<form>
   <table border="1">
     <caption>
     Request Check for <b>Barack</b> <b>Obama</b>
   </caption>
   <thead>
      <tr>
              
              <td>Total Deposit</td>
              <td>Pending Transaction Value</td>
              <td>Cash Balance</td>
          
            </tr>
             </thead>
      <tbody>
            
            <tr> 
              <td>$2000.00</td>
              <td>$200.00</td>
              <td>$400.00</td>
            </tr>

   </tbody></table>
    <hr>
<table>
  <tr>
    <td> Request Check Amount:</td>
    <td> <input name = requestAmount type=“text”></td>
  </tr>

  <tr>
    <td> <button name = “requestCheckSubmit” type=“button”>Request Check Submit</button></td>
  </tr>
</table>

</form>

<jsp:include page="customer-bottomtemplate.jsp" />



