package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController
{
  // Here we use @GetMapping which has no path attached to it
  @GetMapping("/hello")
  public String getHello() {
    // We now return the template called hello
    // which is really hello.html
    return "hello";
  }

  // Here we use @GetMapping which has a path attached to it
  @GetMapping("/info")
  public String getInfo() {
    // We now return the template called info
    // which is really info.html
    return "info";
  }


  // Here we use @GetMapping which has a path attached to it
  @GetMapping("/invoice")
  public String getInvoice() {
    // We now return the template called invoice
    // which is really invoice.html
    return "invoice";
  }

  @RequestMapping(value = "/abc")
  //@ResponseBody
  public String home() {
    return  "abc";
  }

  @RequestMapping(value = "/xml")
  @ResponseBody
  public String sayHello() {

    String resource = "<?xml version='1.0'?>" + "<hello> Welcome, first API example using XML</hello>";
    return resource;

//    String xmlresource = "<?xml version='1.0'?>" + "<name nickname='Gerry'>\n" +
//            "\n" +
//            "  <first>Gerry</first>\n" +
//            "\n" +
//            "  <!--Gerry has a middle name-->\n" +
//            "\n" +
//            "  <middle>Martin</middle>\n" +
//            "\n" +
//            "  <last>Byrne</last>\n" +
//            "\n\n\n" +
//            "</name>" +
//            " <name nickname='David'>\n" +
//            "\n" +
//            "  <first>David</first>\n" +
//            "\n" +
//            "  <!--John lost his middle name in a fire-->\n" +
//            "\n" +
//            "  <middle></middle>\n" +
//            "\n" +
//            "  <last>Wilson</last>\n" +
//            "\n\n\n" +
//            "</name>" +
//            "<bookstore><book ISBN=\"10-000000-001\" \n></book></bookstore>";
//    return xmlresource;
  }


  @RequestMapping(value = "/texthtml", method = RequestMethod.GET)
  @ResponseBody
//  public String sayHelloHTMLParameters(@RequestParam(value ="name", required=false, defaultValue="ANYBODY") String name,
//                                       @RequestParam(value="cardNumber", required=false, defaultValue="1111111") String cardNumber,
//                                       @RequestParam(value ="amount", required=false, defaultValue="99999") int amount)
//  {
  public String sayHelloHTMLParameters(@RequestParam("name") String name, @RequestParam("cardNumber") String cardNumber, @RequestParam("amount") int amount)
  {
    System.out.println("The card holder name is " + name);
    System.out.println("\nThe card number is " + cardNumber);
    System.out.println("\nThe transaction amount is " + amount);
    String response;
    if (amount > 100)
    {
      System.out.println("The transaction amount is greater than your credit limit");
      response = "Credit transaction is not approved";
    }
    else
    {
      System.out.println("The transaction amount is less than your credit limit");
      response = "Credit transaction is approved";
    }
    return "<html>" + "<title>" + "Credit Card Authorisation" + "</title>"
            + "<body><h1>" + name + "<br>" + response + "</br></h1></body>" + "</html>";

  }

}
