## This repository showcases a simple Note-Taking App implemented using the following architectures:

- Classic UI Patterns:
  - MVVM (Model-View-ViewModel)
  - MVC (Model-View-Controller)
  - MVP (Model-View-Presenter)
  - MVI (Model-View-Intent)
- Layered Architectures:
  - Clean Architecture + MVVM
  - Hexagonal Architecture (Ports and Adapters)
  - Layered Architecture
- Specialized Architectures:
  - FLUX Architecture
  - VIPER (View, Interactor, Presenter, Entity, Router)
  - Event-Driven Architecture
  - CQRS (Command Query Responsibility Segregation)
  - Microkernel Architecture
  - Redux Architecture
- Component-Based Architectures:
  - Component-Based Architecture


Each architecture is implemented in its own package, providing a clear and isolated example of how the architecture can be applied to a simple Android app.

### Project Structure:
- com.akshayashokcode.androidarchitectures
  - MVVM
    - model
    - view
    - viewmodel
  - MVC
    - model
    - view
    - controller
  - MVP
    - model
    - view
    - presenter
  - MVI
    - model
    - view
    - intent
  - Clean+MVVM
    - data
      - local
      - repository
    - domain
      - model
      - usecase
    - presentation (MVVM)
      - view
      - viewmodel

