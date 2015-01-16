<jsp:include page="customer-toptemplate.jsp" />
<title> Customer - Sell Fund</title>
<meta charset="utf-8">
<h3>Sell Fund</h3>

<p>
	<form method="post" action="sellfund.do">
       
        <table align='center'>
            <thead>
                <tr>
                    <td width="30%">Fund Name</td>
                    <td>Ticker</td>
                    <td>Share Price</td>
                    <td>Shares</td>
                    <td>Sell/shares </td>
                    
                </tr>
            </thead>
                <tbody>
                <tr>
                    <td width="30%"><a href="">iShares MSCI India Small Cap Index Fund</a></td>
                    <td>SMIN</td>
                    <td>$ 35.55</td>
                    <td>10</td>
                    <td><input type="text" name="fundshare" class="input-block-holder" placeholder="shares willing to sell""/></td>
                    
                </tr>
                    
                <tr>
                    <td width="30%"> <a href=""> Market Vectors India Small-Cap Index ETF</a></td>
                    <td>SCIF</td>
                    <td>$ 47.36</td>
                    <td>3</td>
                    <td><input type="text" name="fundshare" class="input-block-holder" placeholder="shares willing to sell""/></td>
                    
                </tr>
                    
                <tr>
                    <td width="30%"><a href="">Vanguard Russell 2000 ETF</a></td>
                    <td>VTWO</td>
                    <td>$ 92.55</td>
                    <td>5</td>
                    <td><input type="text" name="fundshare" class="input-block-holder" placeholder="shares willing to sell""/></td>
                    
                </tr>
                    <tr>
                    <td width="30%"><a href="">Schwab U.S. Small-Cap ETF</a></td>
                    <td>SCHA</td>
                    <td>$ 53.41</td>
                    <td>2</td>
                        <td><input type="text" name="fundshare" class="input-block-holder" placeholder="shares willing to sell""/></td>
                    
                </tr>
            </tbody>
        </table>
<br>
<input type="submit" name="button" value="Confirm"/>    
                
	</form>
</p>	
		
</body>
               <jsp:include page="customer-bottomtemplate.jsp" />
