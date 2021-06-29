$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("amazon.feature");
formatter.feature({
  "line": 1,
  "name": "Test on Amazon.it",
  "description": "\r\nRule: only test on Amazon.it",
  "id": "test-on-amazon.it",
  "keyword": "Feature"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "start driver",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.startDriver()"
});
formatter.result({
  "duration": 6290407700,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Print the category of amazon",
  "description": "",
  "id": "test-on-amazon.it;print-the-category-of-amazon",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "open amazon",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "print the category",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.openAmazon()"
});
formatter.result({
  "duration": 11262524700,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.printCategory()"
});
formatter.result({
  "duration": 106941900,
  "status": "passed"
});
formatter.after({
  "duration": 915208400,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "start driver",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.startDriver()"
});
formatter.result({
  "duration": 1984183400,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Search the suggest item",
  "description": "",
  "id": "test-on-amazon.it;search-the-suggest-item",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "open amazon",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "make a search of item ipho",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "click on the suggest item",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.openAmazon()"
});
formatter.result({
  "duration": 10699308600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ipho",
      "offset": 22
    }
  ],
  "location": "CucumberTest.searchSuggested(String)"
});
formatter.result({
  "duration": 164965400,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.suggest()"
});
formatter.result({
  "duration": 5368784000,
  "status": "passed"
});
formatter.after({
  "duration": 873433600,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "start driver",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.startDriver()"
});
formatter.result({
  "duration": 1988388300,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Print the evidence item",
  "description": "",
  "id": "test-on-amazon.it;print-the-evidence-item",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "open amazon",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "evidence element are printed",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.openAmazon()"
});
formatter.result({
  "duration": 10047471000,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.evidencePrint()"
});
formatter.result({
  "duration": 1109727300,
  "status": "passed"
});
formatter.after({
  "duration": 877771800,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "start driver",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.startDriver()"
});
formatter.result({
  "duration": 1805825400,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Print item on the first three page",
  "description": "",
  "id": "test-on-amazon.it;print-item-on-the-first-three-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "open amazon",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "make a search of item ipho",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "click on the suggest item",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "item page 1 are printed",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "item page 2 are printed",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "item page 3 are printed",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.openAmazon()"
});
formatter.result({
  "duration": 10898592800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ipho",
      "offset": 22
    }
  ],
  "location": "CucumberTest.searchSuggested(String)"
});
formatter.result({
  "duration": 154732500,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.suggest()"
});
formatter.result({
  "duration": 2576239900,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.printItem()"
});
formatter.result({
  "duration": 5088443800,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.printItem2()"
});
formatter.result({
  "duration": 3330925100,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.printItem3()"
});
formatter.result({
  "duration": 3192881300,
  "status": "passed"
});
formatter.after({
  "duration": 993703100,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "start driver",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.startDriver()"
});
formatter.result({
  "duration": 1879835800,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Open three element in three new tab",
  "description": "",
  "id": "test-on-amazon.it;open-three-element-in-three-new-tab",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "open amazon",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "search item iphone",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "open new tab",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.openAmazon()"
});
formatter.result({
  "duration": 8681692000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iphone",
      "offset": 12
    }
  ],
  "location": "CucumberTest.search(String)"
});
formatter.result({
  "duration": 2868931700,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.newTab()"
});
formatter.result({
  "duration": 45809750000,
  "status": "passed"
});
formatter.after({
  "duration": 1096700100,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "start driver",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.startDriver()"
});
formatter.result({
  "duration": 1916529500,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Print number of element",
  "description": "",
  "id": "test-on-amazon.it;print-number-of-element",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 35,
  "name": "open amazon",
  "keyword": "Given "
});
formatter.step({
  "line": 36,
  "name": "search item iphone",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "print number",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.openAmazon()"
});
formatter.result({
  "duration": 11923035100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iphone",
      "offset": 12
    }
  ],
  "location": "CucumberTest.search(String)"
});
formatter.result({
  "duration": 2676232200,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.printItemNumber()"
});
formatter.result({
  "duration": 3652286900,
  "status": "passed"
});
formatter.after({
  "duration": 985444700,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "start driver",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.startDriver()"
});
formatter.result({
  "duration": 1829878900,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Add to cart and clear cart",
  "description": "",
  "id": "test-on-amazon.it;add-to-cart-and-clear-cart",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 40,
  "name": "open amazon",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "search item groot",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "add item mascherina item borraccia item rocket at cart",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "clear cart",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.openAmazon()"
});
formatter.result({
  "duration": 10729775200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "groot",
      "offset": 12
    }
  ],
  "location": "CucumberTest.search(String)"
});
formatter.result({
  "duration": 2819337600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mascherina",
      "offset": 9
    },
    {
      "val": "borraccia",
      "offset": 25
    },
    {
      "val": "rocket",
      "offset": 40
    }
  ],
  "location": "CucumberTest.addCart(String,String,String)"
});
formatter.result({
  "duration": 49280624100,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.clearCart()"
});
formatter.result({
  "duration": 4650190400,
  "status": "passed"
});
formatter.after({
  "duration": 1106321600,
  "status": "passed"
});
});