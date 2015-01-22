<jsp:include page="customer-toptemplate.jsp" />
<title>Customer - Search Fund Result</title>
<br>
<br>
<br>

<p>
<form method="GET" action="sresearch_funds.do">
	<table>
		<tr>
		<td></td>
			<td style="font-size: medium">Find a Fund:</td>
			<td><input type="text" name="fundKeyWord"
				class="input-block-holder" placeholder="Fund name/ticker"/></td>
			<td colspan="2" align="right"><input type="submit"
				class="button-secondary form_item-medium right" name="button"
				value="Search" /> <a href="customer_Fundlist.jsp">See all Funds</a>

			</td>

		</tr>
	</table>

</form>

<table>
	 <c:forEach var="fund" items="${funds}">
        <tr>
        	<td>${fund.fundId}</td>
        	<td>${fund.fundName}</td>
        	<td>${fund.symbol}</td>
        </tr>
    </c:forEach>
</table>
</p>
</td>
</tr>
</table>

<h3>Performance</h3>
<img
	src="http://chart.apis.google.com/chart?chxt=x,y,r&chds=9,25&chd=t:10.0,12.3,15.4,11.3,16.7,18.4,24.3|10.0,12.0,16.7,10.9,16.4,17.0,21.2&chxs=0,000000,11,0,lt,ffffff|1,,0,0,l|2,000000&chxtc=0,10|2,-620&chco=1293ba,d03739&chs=425x310&cht=lc&chxl=0:|12/2003|10/2005|8/2007|6/2009|4/2011|2/2013|11/2014|2:|$9K|$12.2K|$15.4K|$18.6K|$21.8K|$25K&chls=2.0|2.0,6.0,6.0&chdl=Royce+Financial+Services+Fund|MSCI+ACWI+NR+USD&chdlp=bv&chdls=000000">
</body>
<jsp:include page="customer-bottomtemplate.jsp" />