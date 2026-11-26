---
title: "resume"
date: 2021-11-09T18:24:00Z
slug: resume
---

# RAFAEL DELBONI

**Senior Software Engineer (Backend, Distributed Systems & Security)**
Brazilian, GMT-3, remote-first, São Paulo, Brazil
[rafael@delboni.cc](mailto:rafael@delboni.cc) - [rafael.delboni.cc](http://rafael.delboni.cc) - [github.com/rafaeldelboni](https://github.com/rafaeldelboni) - [linkedin.com/in/rafaeldelboni](https://linkedin.com/in/rafaeldelboni)

---

**SUMMARY**

Backend engineer with 18+ years of experience. For the last 5 years I have been working with identity, authorization and cryptography at Nubank (100+ million customers). I built an IAM system in-house, an access request platform on top of it, and a new authentication protocol based on macaroons, now being rolled out to the full customer base with zero downtime. Comfortable with distributed microservices, event streaming and infrastructure as code. Several years working fully remote (Nubank, 180s), plus one year working on-site abroad in Amsterdam (2017-2018).

**HIGHLIGHTS**

* Built Nubank's in-house IAM system from the ground up, including all core connectors and integrations (LDAP/AD, HR systems, cloud providers, CI/CD), replacing the previous internal system for all internal access management.
* Built a full stack access request platform on top of the IAM system: access requests for any grouping (team, product, role, custom groups), escalation rules to group owners or people managers, and time and criticality rules for approving or rejecting requests. Adoption grew organically team by team, now with ~160 service integrations and ~7M API calls.
* Created a new in-house authentication protocol based on macaroons (tokens that authorize actions in a decentralized way, with caveats), offering proof-of-possession security comparable to mTLS while being much simpler to integrate, replacing a previous credential setup based on mTLS and JWT. Implemented end to end across Clojure backend, TypeScript web and Dart mobile clients.
* Driving the staged rollout of this protocol over the last 2 years with zero downtime, currently expanding it towards the full customer base: ramping up the rollout percentage while monitoring key metrics for user impact, holding the rollout to fix and reevaluate whenever a regression shows up. The service already handles hundreds of millions of token emissions per day, on track for billions at full scale.
* Mentored ~4 engineers and drove the platform adoption across teams.

**TECHNICAL SKILLS**

* Languages: Clojure, Rust, C/C++, Zig, Lua, Fennel, TypeScript/JavaScript, Node.js, Dart, C#, PHP
* Security & Identity: IAM/IGA, authentication and authorization protocols, macaroons, cryptography
* Distributed systems: Kafka, microservices (Finagle, hexagonal architecture), event-driven design, Kubernetes, Prometheus
* Data: Datomic, XTDB/Crux, PostgreSQL, MySQL, MSSQL, SQLite, DynamoDB, MongoDB, Redis
* Infrastructure & tooling: AWS, Pulumi (IaC), Docker, Kubernetes, Tekton/GitHub Actions, Git, Vim/tmux

---

**PROFESSIONAL EXPERIENCE**

**Nubank - Senior Software Engineer, Cryptography & Identity Team** - Jul/2022 to present
*Rolling out a new authentication protocol to the full customer base, 2+ years of progressive migration with zero downtime.*

* Designed and developed a new in-house authentication protocol based on macaroons, replacing a previous credential setup based on mTLS and JWT that made web integrations and multi-account usage hard. The new protocol offers proof-of-possession security comparable to mTLS while being much simpler to integrate going forward, and was implemented across the whole stack: Clojure on the backend, TypeScript on the web and Dart on mobile.
* Driving a staged, zero-downtime rollout of this protocol to the full customer base (100M+ customers) over the last 2 years, still in progress: ramping up the rollout percentage while monitoring key metrics for user impact, holding the rollout to fix and reevaluate whenever a regression or new pattern shows up. The service already handles hundreds of millions of token emissions per day.
* Built the company-wide IAM system from the ground up, including all core integrations and connectors (HR, cloud, CI/CD), replacing the previous solution and becoming the source of truth for internal identity and access.
* Built a full stack access request platform on top of the IAM system: access requests for any grouping (team, product, role, custom groups), escalation chains to group owners or people managers, and rules for criticality and time to accept/reject. Adoption grew organically: the team documented the integrations and showed engineers the data the platform provides, and it now handles ~7M API calls with ~160 service integrations.
* Horizontally scalable microservices written in Clojure (Finagle), high throughput communication with Kafka, storage in Datomic and DynamoDB, observability with Prometheus, CI/CD on AWS with Tekton, running on Kubernetes.

**180s - Software Engineer** - May/2021 to Jun/2022

* Horizontally scalable Clojure microservices (functional programming, hexagonal architecture); communication and high throughput jobs with Kafka; PostgreSQL, Crux, Datomic and DynamoDB; observability on Kubernetes; CI/CD on AWS; infrastructure as code with Pulumi across multiple AWS accounts.

**Nubank - Software Engineer** - May/2019 to May/2021

* Horizontally scalable microservices in Clojure (Finagle) with functional programming and hexagonal architecture; high throughput jobs and communication with Kafka; Datomic and DynamoDB; Prometheus observability; Kubernetes, CI/CD on AWS.

**Lambda3 - Full-Stack Developer** - Jun/2018 to May/2019

* Asynchronous message queue processing systems for SMS and payment services; .NET/ASP.NET Core, MySQL + Entity, RabbitMQ; unit and integration testing with XUnit, Moq, FluentAssertions.

**Deskbookers (Netherlands) - Full-Stack Developer** - May/2017 to Jun/2018

* Multi-country, multi-language e-commerce platform for booking meeting rooms, plus the venues back-office; PHP and Node.js backends (PostgreSQL + Knex, Redis, Elasticsearch), React/Redux frontend, CI/CD on AWS.

**Lambda3 - Full-Stack Developer** - Aug/2016 to May/2017

* Administrative and financial systems; .NET/ASP.NET Core + MSSQL (NHibernate); acceptance testing with Chimp/Mocha/WebDriverIO; CI/CD on Azure/VSTS.

**Itaú Unibanco - System Analyst** - Oct/2011 to Aug/2016

* Private Banking systems: BI and account management tooling, transaction web services, internal back-office web applications; international projects (Switzerland and Miami).
* Awarded the "Y Axis" peer-recognition prize (2012, 2013, 2015) and the WMS innovation challenge (2015).

**Canon do Brasil - Solution Analyst** - Feb/2007 to Oct/2011

* Integrations between customers systems and Canon software (.NET/C#), reporting services, 2nd and 3rd level support and English-language support for Canon Latin America (Miami); managed Linux hosting (PHP + PostgreSQL).

---

**PERSONAL PROJECTS** *(selected, full list at [rafael.delboni.cc](http://rafael.delboni.cc))*

* **[stabilis](https://rafael.delboni.cc/stabilis/)** - static site generator written in Zig, markdown in, static HTML out, no backend. _[source](https://github.com/rafaeldelboni/stabilis)_
* **[docs.clj.codes](https://docs.clj.codes/)** - a modern clojuredocs.org reimplementation. _[source](https://github.com/clj-codes/docs)_
* **[cajus-nvim](https://github.com/rafaeldelboni/cajus-nvim)** - turns Neovim into a full Clojure IDE using Fennel, clojure-lsp and Conjure.
* **[microservice-boilerplate](https://github.com/parenthesin/microservice-boilerplate)** - Clojure microservice boilerplate: components, Reitit, Pedestal, PostgreSQL, tests. _[source](https://github.com/parenthesin/microservice-boilerplate)_
* **[6502 Emulator](https://github.com/nopsteam/6502)** - a 6502 emulator written in pure C.
* **[Feles Tales](https://rafaeldelboni.itch.io/feles-tales)** - 3D game built with Squint, Three.js, Rapier and Recast. / **[Zero to Hero](https://rafaeldelboni.itch.io/zero-to-hero)** - 2D puzzle-platformer with ClojureScript + Phaser.

**ACADEMIC BACKGROUND**

* Bachelor of Computer Information Systems, Fundação Santo André (2010)
* Master Class Digital Acceleration, Hyper Island (2015)
* Mechatronics Technician, Instituto Pentágono (2005)

**LANGUAGES & INTERNATIONAL EXPERIENCE**

* Portuguese (native), English (professional working proficiency, interviewed and worked in English)
* Worked abroad: Amsterdam, Netherlands (1 year, 2017-2018); Zürich, Switzerland (system deploy and training, 2015)
