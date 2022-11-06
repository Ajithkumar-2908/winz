CREATE TABLE [dbo].[PlanSponsor]
(
    Id int NOT NULL IDENTITY (1,1),
    [Name] varchar(255) NOT NULL UNIQUE,
    [Location] varchar(255) NOT NULL,
    CreatedDate DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedDate DATETIME NOT NULL DEFAULT GETDATE()
    CONSTRAINT PK_PlanSponsor_Id PRIMARY KEY (Id)
)

CREATE TABLE [dbo].[Plan]
(
    Id int NOT NULL IDENTITY (1,1),
    [Name] varchar(255) NOT NULL,
    [TaxType] varchar(5) NOT NULL UNIQUE,
    CreatedDate DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedDate DATETIME NOT NULL DEFAULT GETDATE()
    CONSTRAINT PK_Plan_Id PRIMARY KEY (Id)
)

CREATE TABLE [dbo].[Product]
(
    Id int NOT NULL IDENTITY (1,1),
    GrantType varchar(3) NOT NULL UNIQUE,
    OgaIndicator bit NOT NULL DEFAULT 0,
    CreatedDate DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedDate DATETIME NOT NULL DEFAULT GETDATE()
    CONSTRAINT PK_Product_Id PRIMARY KEY (Id)
)

-- CREATE TABLE [dbo].[Supervisor]
-- (
--     Id int NOT NULL IDENTITY (1,1),
--     [Name] varchar(255) NOT NULL,
--     [EmpCode] varchar(5) NOT NULL UNIQUE,
--     IsActive bit NOT NULL DEFAULT 1,
--     CreatedDate DATETIME NOT NULL DEFAULT GETDATE(),
--     UpdatedDate DATETIME NOT NULL DEFAULT GETDATE(),
--     CONSTRAINT PK_Supervisor_Id PRIMARY KEY (Id)
-- )

-- CREATE TABLE [dbo].[Employee]
-- (
--     Id int NOT NULL IDENTITY (1,1),
--     [Name] varchar(255) NOT NULL,
--     [EmpCode] varchar(5) NOT NULL UNIQUE,
--     IsActive bit NOT NULL DEFAULT 1,
--     CreatedDate DATETIME NOT NULL DEFAULT GETDATE(),
--     UpdatedDate DATETIME NOT NULL DEFAULT GETDATE(),
--     CONSTRAINT PK_Employee_Id PRIMARY KEY (Id)
-- )



CREATE TABLE RelationshipTreeNode
(
    Id uniqueidentifier NOT NULL DEFAULT NEWID(),
    [HierarchyId] hierarchyid NOT NULL UNIQUE,
    [Level] AS ([HierarchyId].GetLevel()),
    PlanSponsorId int DEFAULT NULL,
    PlanId int DEFAULT NULL,
    ProductId int DEFAULT NULL,
    CreatedDate DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedDate DATETIME NOT NULL DEFAULT GETDATE(),
    CONSTRAINT PK_RelationshipTreeNode_Id PRIMARY KEY NONCLUSTERED (Id)
)

ALTER TABLE RelationshipTreeNode
ADD CONSTRAINT FK_PlanSponsor_Id
FOREIGN KEY (PlanSponsorId) REFERENCES PlanSponsor(Id)

ALTER TABLE RelationshipTreeNode
ADD CONSTRAINT FK_Plan_Id
FOREIGN KEY (PlanId) REFERENCES [Plan](Id)

ALTER TABLE RelationshipTreeNode
ADD CONSTRAINT FK_Product_Id
FOREIGN KEY (ProductId) REFERENCES Product(Id)

INSERT INTO PlanSponsor (Name, [Location])
VALUES ('CAT', 'Chennai'),
('FI', 'Chennai')

INSERT INTO [Plan] (Name, TaxType)
VALUES ('Plan1', 'WHT'),
('Plan2', 'BGT')

INSERT INTO [Product] (GrantType, OgaIndicator)
VALUES ('CSH', 0),
('RSU', 0)