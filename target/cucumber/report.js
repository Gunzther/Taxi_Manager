$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/order.feature");
formatter.feature({
  "line": 1,
  "name": "Order products",
  "description": "  As a manager\n  I want the inventory to be deducted accordingly, so that I know if the order can be fulfilled.",
  "id": "order-products",
  "keyword": "Feature"
});
formatter.before({
  "duration": 18343582,
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
  "name": "a product Bread with price 20 Baht with quantity 100 in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "a product Jam with price 10 Baht with quantity 30 in the inventory",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Bread",
      "offset": 10
    },
    {
      "val": "20",
      "offset": 27
    },
    {
      "val": "100",
      "offset": 49
    }
  ],
  "location": "BuyStepdefs.a_product_with_quantity_in_inventory(String,double,int)"
});
formatter.result({
  "duration": 152597612,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jam",
      "offset": 10
    },
    {
      "val": "10",
      "offset": 25
    },
    {
      "val": "30",
      "offset": 47
    }
  ],
  "location": "BuyStepdefs.a_product_with_quantity_in_inventory(String,double,int)"
});
formatter.result({
  "duration": 139588,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Order small quantity",
  "description": "",
  "id": "order-products;order-small-quantity",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I buy Bread with quantity 2",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I buy Jam with quantity 1",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "a product Bread in the inventory should remain 98 left",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "a product Jam in the inventory should remain 29 left",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Bread",
      "offset": 6
    },
    {
      "val": "2",
      "offset": 26
    }
  ],
  "location": "BuyStepdefs.i_buy_with_quantity(String,int)"
});
formatter.result({
  "duration": 177090,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jam",
      "offset": 6
    },
    {
      "val": "1",
      "offset": 24
    }
  ],
  "location": "BuyStepdefs.i_buy_with_quantity(String,int)"
});
formatter.result({
  "duration": 88172,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bread",
      "offset": 10
    },
    {
      "val": "98",
      "offset": 47
    }
  ],
  "location": "BuyStepdefs.product_should_remain(String,int)"
});
formatter.result({
  "duration": 189326627,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jam",
      "offset": 10
    },
    {
      "val": "29",
      "offset": 45
    }
  ],
  "location": "BuyStepdefs.product_should_remain(String,int)"
});
formatter.result({
  "duration": 117687,
  "status": "passed"
});
formatter.before({
  "duration": 198359,
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
  "name": "a product Bread with price 20 Baht with quantity 100 in the inventory",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "a product Jam with price 10 Baht with quantity 30 in the inventory",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Bread",
      "offset": 10
    },
    {
      "val": "20",
      "offset": 27
    },
    {
      "val": "100",
      "offset": 49
    }
  ],
  "location": "BuyStepdefs.a_product_with_quantity_in_inventory(String,double,int)"
});
formatter.result({
  "duration": 153791,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jam",
      "offset": 10
    },
    {
      "val": "10",
      "offset": 25
    },
    {
      "val": "30",
      "offset": 47
    }
  ],
  "location": "BuyStepdefs.a_product_with_quantity_in_inventory(String,double,int)"
});
formatter.result({
  "duration": 148874,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Order large quantity",
  "description": "",
  "id": "order-products;order-large-quantity",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "I buy Bread with quantity 101",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "a product Bread in the inventory should remain 100 left",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Bread",
      "offset": 6
    },
    {
      "val": "101",
      "offset": 26
    }
  ],
  "location": "BuyStepdefs.i_buy_with_quantity(String,int)"
});
formatter.result({
  "duration": 1669877,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bread",
      "offset": 10
    },
    {
      "val": "100",
      "offset": 47
    }
  ],
  "location": "BuyStepdefs.product_should_remain(String,int)"
});
formatter.result({
  "duration": 101181,
  "status": "passed"
});
});