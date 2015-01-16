<jsp:include page="employee-toptemplate.jsp" />
<title> Employee - Create Fund</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html lang="en">

<h4>Create Fund</h4>

<p>
	<form method="post" action="create fund.do">
       
    <div class="fund_details_fields">
    <label for="fundname"> Fund Name <span class="mandatory">*</span></label><br>
		<input id="fundname" maxlength="35" name="fundname" value="" type="text" size="20"><input name="_D:fundname" value=" " type="hidden">
	</div>
	
	<div class="fund_details_fields">
		<label for="ticker"> ticker <span class="mandatory">*</span></label><br>
		<input id="ticker" maxlength="5" name="ticker" value="" type="text" size="50"><input name="_D:ticker" value=" " type="hidden">
	</div>

<br>
<input type="submit" name="button" value="Create"/>    
                
	</form>
</p>	
		</td>
	</tr>
</table>
</body>
      <jsp:include page="employee-bottomtemplate.jsp" />