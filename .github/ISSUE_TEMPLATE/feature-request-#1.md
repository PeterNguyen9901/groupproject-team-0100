---
name: 'Feature request #1'
about: Split Menu.java into multiple classes
title: Menu.java fix
labels: ''
assignees: PeterNguyen9901

---

The current problem is that Menu.java contains the logic and pages of the fight screen, shop, statistics, and home page.

I want the menu class to be split into different classes for each screen to make the code more versatile and friendly to future updates. 

There will be a main.java class that will be in charge of launching the program and the main home page. This class will be in charge of opening and closing the different game pages.

Each one of the pages fight, shop, and stats will be their own separate page and class.
