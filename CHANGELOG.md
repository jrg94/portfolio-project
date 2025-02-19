# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## [2025.02.05]

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

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07
