<jsp:include page="employee-toptemplate.jsp" />
<p> Welcome John! </p>
<hr>
    <p style="font-size: medium">select a customer</p>

<select name="customerlist" size="1" class="arrow" tabindex="11">
	<c:forEach var="customer" items="${customerList}">
		<option value="customerid"><span class="menu-item"> <a
				href="list.do?userid=${customer.customerid}">${customer.firstName}
					${customer.lastName}</a>
			</span>
		</option>
	</c:forEach>
</select>
    <hr>


<form>
   <table border="1">
     <caption>
     Transaction History of <b>Barack</b> <b>Obama</b>
  
   </caption>
   <thead>
      <tr>
              
              <td>Transaction Data</td>
              <td>Operation</td>
              <td>Fund Name</td>
              <td>Number of Shares</td>
              <td>Share Price</td>
              <td>Dollor Amount</td>
              <td>Pending Status</td>
            </tr>
             </thead>
      <tbody>
            
            <tr> 
              <td>11/20/2014</td>
              <td>Deposit</td>
              <td>&nbsp</td>
              <td>&nbsp</td>
              <td>&nbsp</td>
              <td>$200.00</td>
              <td>&nbsp</td>
            </tr>

             <tr> 
              <td>11/21/2014</td>
              <td>Buy</td>
              <td>ABB</td>
              <td>10.00</td>
              <td>$20.00</td>
              <td>$200.00</td>
              <td>&nbsp</td>
            </tr>
            
           <tr>
              
              <td>11/22/2014</td>
              <td>Sell</td>
              <td>ABB</td>
              <td>10.00</td>
              <td>$21.00</td>
              <td>$210.00</td>
              <td>&nbsp</td>
            </tr>
            <tr>
              
              <td>11/23/2014</td>
              <td>Request Check</td>
              <td>&nbsp</td>
              <td>&nbsp</td>
              <td>&nbsp</td>
              <td>$210.00</td>
              <td>Pending</td>
            </tr>
   
   
   
   </tbody></table>


     <!--          <td><input type="text" size="5" value="2" align="center"></td> -->

</div>

</form>

 <jsp:include page="employee-bottomtemplate.jsp" />




