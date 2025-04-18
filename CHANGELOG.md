# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## [2025.02.05]

### Added

- Designed a Video Player component
- Designed a Shortest Path Finder component
- Designed a Text Complexity Analyzer component

## [2025.02.19]

### Added
- Implemented a partial proof-of-concept for the **Shortest Path Finder** component.
- Added core methods: `addLocation(String location)`, `addPath(String from, String to, double weight)`, and `isConnected(String from, String to)`.
- Created a minimal `main` method to test the basic functionality of the component.
- Documented the data structure used (HashMap for graph representation).

### Updated
- Clarified the scope of the proof-of-concept assignment to ensure it aligns with OSU discipline expectations.
- Modified `CHANGELOG.md` to reflect the latest progress on the project.

### Fixed
- Resolved minor issues with project setup related to branch creation and local repository cloning.

## [2024.03.04]

### Added
- Designed and implemented the ShortestPathFinder1 component to manage graph connections and pathfinding.
- Introduced the following core methods:
- addLocation(String location): Adds a location to the graph if it does not already exist.
- addPath(String from, String to, double weight): Adds a path between two locations (undirected graph).
- isConnected(String from, String to): Checks if there is a direct connection between two locations.
- shortestPath(String from, String to): Placeholder for implementing a real pathfinding algorithm (currently returns 0.0).

### Updated
- Enhanced the design with detailed comments on the implementation and real-world relevance of the project, including potential uses in industries such as automotive, logistics, and gaming.
- Improved the code structure to accommodate future pathfinding algorithms and defined a placeholder for shortestPath() to demonstrate its usage.

### Fixed
- Resolved issues related to graph initialization and edge handling to ensure that paths are properly added between locations.

## [2025.03.25]

### Added
- Created abstract class `ShortestPathFinderSecondary` as part of the enhanced interface layer.
- Implemented `shortestPath(String from, String to)` using kernel methods only (simulated Dijkstra’s with BFS style logic).
- Added common `Object` methods: `toString()`, `equals()`, and `hashCode()` with logic built entirely on public interface methods.
- Included helper methods `getLocations()` and `hasLocation(String location)` to support abstraction and method implementation.

### Updated
- Confirmed that secondary methods do not depend on internal representation (`Map<String, Queue<Edge>>`) and respect the design-by-contract principle.
- Documented method limitations and override requirements in abstract method stubs



[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07
