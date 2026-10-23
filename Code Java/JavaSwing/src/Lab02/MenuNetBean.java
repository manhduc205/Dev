/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author DucPc
 */
public class MenuNetBean extends JFrame{
    JMenuBar menubar;
    public MenuNetBean(){
        initFrame();
        initMenuBar();
        initToolBar();
        setVisible(true);
    }
    public static void main(String[] args) {
        MenuNetBean  demo = new MenuNetBean ();
    }
    private void initFrame(){
        this.setLayout(new BorderLayout());
        this.setSize(850,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Demo JFrame");
        
    }
    private void initMenuBar(){
        menubar = new JMenuBar();
        initMenuFile();
        initMenuEdit();
        initMenuView();
        initMenuNavigate();
        initMenuSource();
        initMenuRefactor();
        initMenuRun();
        initMenuDebug();
        initMenuProfile();
        initMenuTeam();
        initMenuTools();
        initMenuWindow();
        initMenuHelp();

        this.setJMenuBar(menubar);
        
    }
    private void initMenuFile(){
        JMenu menuFile = new JMenu("File");
        ImageIcon icon = new ImageIcon("C:/Users/DucPc/Desktop/hai.jpg");
        icon = resizeImageIcon(icon, 16, 16);
        JMenuItem newProject = new JMenuItem("New Project",icon); 
        newProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK| InputEvent.SHIFT_DOWN_MASK));
        menuFile.add(newProject);
        //-------------
        ImageIcon icon2 = new ImageIcon("C:\\Users\\DucPc\\Desktop\\icon.png");
        icon2 = resizeImageIcon(icon, 16, 16);  
        JMenuItem newFile = new JMenuItem("New File...", icon2);
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        menuFile.add(newFile);
        menuFile.addSeparator();
        //--------
        
        icon2 = resizeImageIcon(icon, 16, 16);  
         JMenuItem openProject = new JMenuItem("Open Project...", icon2);
        openProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        menuFile.add(openProject);
        
        // --- 
        JMenuItem closeProject = new JMenuItem("Close Project");
        JMenuItem closeOtherProjects = new JMenuItem("Close Other Projects");
        JMenuItem closeAllProjects = new JMenuItem("Close All Projects");
        menuFile.add(closeProject);
        menuFile.add(closeOtherProjects);
        menuFile.add(closeAllProjects);

        menuFile.addSeparator();

        //------- Open File 
        JMenuItem openFile = new JMenuItem("Open File..");
        menuFile.add(openFile);

        //--
        JMenu openRecentFile = new JMenu("Open Recent File");
        JMenuItem recentFile1 = new JMenuItem("file1.txt");
        JMenuItem recentFile2 = new JMenuItem("file2.java");
        openRecentFile.add(recentFile1);
        openRecentFile.add(recentFile2);
        menuFile.add(openRecentFile);
        menuFile.addSeparator();

        // -------
        JMenuItem projectGroups = new JMenuItem("Project Groups...");
        JMenuItem projectProperties = new JMenuItem("Project Properties");
        menuFile.add(projectGroups);
        menuFile.add(projectProperties);
        menuFile.addSeparator();  
        //-----open recent file
        JMenu importPj = new JMenu("Import Project");
        JMenuItem file1 = new JMenuItem("2 Project",icon2); 
        file1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK| InputEvent.SHIFT_DOWN_MASK));
        importPj.add(file1);
        menuFile.add(importPj);
        
        menubar.add(menuFile);
    }
    private void initMenuEdit() {
        JMenu editMenu = new JMenu("Edit");
        ImageIcon iconUndo = new ImageIcon("C:/Users/DucPc/Desktop/undo.jpg");
        iconUndo = resizeImageIcon(iconUndo, 16, 16);

        ImageIcon iconRedo = new ImageIcon("C:/Users/DucPc/Desktop/redo.jpg");
        iconRedo = resizeImageIcon(iconRedo, 16, 16);

        //----------------
        JMenuItem undo = new JMenuItem("Undo");
        undo.setIcon(iconUndo);
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(undo);
        // --------------
        JMenuItem redo = new JMenuItem("Redo");
        redo.setIcon(iconRedo);
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(redo);
        editMenu.addSeparator();

        //------
        JMenuItem cut = new JMenuItem("Cut");   
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(cut);
        //-------
        JMenuItem copy = new JMenuItem("Copy");      
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(copy);
        //--
        JMenuItem paste = new JMenuItem("Paste");       
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(paste);

        //-----
        JMenuItem pasteFormatted = new JMenuItem("Paste Formatted");
        pasteFormatted.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        editMenu.add(pasteFormatted);

        //------
        JMenuItem pasteFromHistory = new JMenuItem("Paste from History");
        pasteFromHistory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        editMenu.add(pasteFromHistory);

        //-----s
        JMenuItem pasteAsLines = new JMenuItem("Paste as Lines");
        pasteAsLines.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        editMenu.add(pasteAsLines);

        editMenu.addSeparator();

        //---
        JMenuItem deleteItem = new JMenuItem("Delete");
        
        deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        editMenu.add(deleteItem);

        //----
        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(selectAll);

        JMenuItem selectIdentifier = new JMenuItem("Select Identifier");
        selectIdentifier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(selectIdentifier);

        editMenu.addSeparator();

        // ---------------
        JMenuItem findSelection = new JMenuItem("Find Selection");
        findSelection.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_DOWN_MASK));
        editMenu.add(findSelection);

        JMenuItem findNext = new JMenuItem("Find Next");
        findNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        editMenu.add(findNext);

        JMenuItem findPrevious = new JMenuItem("Find Previous");
        findPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_DOWN_MASK));
        editMenu.add(findPrevious);

        menubar.add(editMenu);
    }

    private void initMenuView() {
    JMenu viewMenu = new JMenu("View");
    //-----
    JMenu editorsMenu = new JMenu("Editors");
    JMenuItem editor1 = new JMenuItem("Source");
    JMenuItem editor2 = new JMenuItem("Design");
    JMenuItem editor3 = new JMenuItem("History");
    editorsMenu.add(editor1);
    editorsMenu.add(editor2);
    editorsMenu.add(editor3);
    viewMenu.add(editorsMenu);

    //---------
    JMenu splitMenu = new JMenu("Split");

    JMenuItem splitHoriz = new JMenuItem("Split Horiontally");
    JMenuItem splitVert  = new JMenuItem("Split Vertically");
    splitMenu.add(splitHoriz);
    splitMenu.add(splitVert);
    viewMenu.add(splitMenu);
    //------
    JMenu codeFoldsMenu = new JMenu("Code Folds");
    JMenuItem collapseFold = new JMenuItem("Collapse Fold");
    JMenuItem expandFold   = new JMenuItem("Expand Fold");
    codeFoldsMenu.add(collapseFold);
    codeFoldsMenu.add(expandFold);
    viewMenu.add(codeFoldsMenu);
    viewMenu.addSeparator();
    //-----
    JMenuItem ideLog = new JMenuItem("IDE Log");
    viewMenu.add(ideLog);
    viewMenu.addSeparator();
    //-
    JMenu toolbarsMenu = new JMenu("Toolbars");
    JMenuItem showMainToolbar   = new JMenuItem("Main Toolbar");
    JMenuItem showDebugToolbar  = new JMenuItem("Debug Toolbar");
    JMenuItem showNavToolbar    = new JMenuItem("Navigation Toolbar");
    toolbarsMenu.add(showMainToolbar);
    toolbarsMenu.add(showDebugToolbar);
    toolbarsMenu.add(showNavToolbar);

    viewMenu.add(toolbarsMenu);
    menubar.add(viewMenu);
}

    private void initMenuNavigate() {
    JMenu navMenu = new JMenu("Navigate");

    JMenuItem goToFile = new JMenuItem("Go to File...");
    goToFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    navMenu.add(goToFile);

    JMenuItem goToType = new JMenuItem("Go to Type...");
    goToType.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
    navMenu.add(goToType);

    JMenuItem goToSymbol = new JMenuItem("Go to Symbol...");
    goToSymbol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    navMenu.add(goToSymbol);

    JMenuItem goToSpringBean = new JMenuItem("Go to Spring Bean...");
    goToSpringBean.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
    navMenu.add(goToSpringBean);
    JMenuItem goToTest = new JMenuItem("Go to Test/Tested class");
    goToTest.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
    navMenu.add(goToTest);
    JMenuItem goToPrevWindow = new JMenuItem("Go to Previous Window");
    goToPrevWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
    navMenu.add(goToPrevWindow);

    navMenu.addSeparator();
    JMenuItem goToSource = new JMenuItem("Go to Source");
    goToSource.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    navMenu.add(goToSource);

    JMenuItem goToDeclaration = new JMenuItem("Go to Declaration");
    goToDeclaration.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
    navMenu.add(goToDeclaration);

    JMenuItem goToSuper = new JMenuItem("Go to Super Implementation");
    goToSuper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    navMenu.add(goToSuper);

    JMenu inspectMenu = new JMenu("Inspect");
    inspectMenu.add(new JMenuItem("Analyze File"));
    inspectMenu.add(new JMenuItem("Analyze Project"));
    navMenu.add(inspectMenu);

    navMenu.addSeparator();
    JMenuItem lastEditLoc = new JMenuItem("Last Edit Location");
    lastEditLoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
    navMenu.add(lastEditLoc);

    JMenuItem back = new JMenuItem("Back");
    back.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.ALT_DOWN_MASK));
    navMenu.add(back);
    JMenuItem forward = new JMenuItem("Forward");
    forward.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.ALT_DOWN_MASK));
    navMenu.add(forward);
    menubar.add(navMenu);
    }

    private void initMenuSource() {
    JMenu sourceMenu = new JMenu("Source");

    // ----- 
    JMenuItem format = new JMenuItem("Format");
    format.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(format);
    JMenuItem removeTrailing = new JMenuItem("Remove Trailing Spaces");
    sourceMenu.add(removeTrailing);

    sourceMenu.addSeparator();
    JMenuItem shiftLeft = new JMenuItem("Shift Left");
    shiftLeft.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(shiftLeft);

    JMenuItem shiftRight = new JMenuItem("Shift Right");
    shiftRight.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(shiftRight);

    JMenuItem moveUp = new JMenuItem("Move Up");
    moveUp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(moveUp);

    JMenuItem moveDown = new JMenuItem("Move Down");
    moveDown.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(moveDown);

    sourceMenu.addSeparator();
    JMenuItem moveElementUp = new JMenuItem("Move Code Element Up");
    moveElementUp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(moveElementUp);

    JMenuItem moveElementDown = new JMenuItem("Move Code Element Down");
    moveElementDown.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(moveElementDown);

    sourceMenu.addSeparator();
    JMenuItem dupUp = new JMenuItem("Duplicate Up");
    dupUp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(dupUp);

    JMenuItem dupDown = new JMenuItem("Duplicate Down");
    dupDown.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
    sourceMenu.add(dupDown);
    JMenuItem toggleComment = new JMenuItem("Toggle Comment");
    toggleComment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, InputEvent.CTRL_DOWN_MASK));
    sourceMenu.add(toggleComment);

    sourceMenu.addSeparator();
    JMenuItem completeCode = new JMenuItem("Complete Code...");
    completeCode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_DOWN_MASK));
    sourceMenu.add(completeCode);
    JMenuItem insertCode = new JMenuItem("Insert Code...");
    insertCode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, InputEvent.ALT_DOWN_MASK));
    sourceMenu.add(insertCode);
    menubar.add(sourceMenu);
    }

    private void initMenuRefactor() {
    JMenu menu = new JMenu("Refactor");

    JMenuItem rename = new JMenuItem("Rename...");
    rename.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));

    JMenuItem move = new JMenuItem("Move...");
    move.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));

    JMenuItem copy = new JMenuItem("Copy...");
    copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));

    JMenuItem safelyDelete = new JMenuItem("Safely Delete...");
    safelyDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, InputEvent.ALT_DOWN_MASK));

    JMenuItem inlineItem = new JMenuItem("Inline...");
    inlineItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
            InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));

    JMenuItem changeParams = new JMenuItem("Change Method Parameters...");

    JMenuItem pullUp = new JMenuItem("Pull Up...");
    JMenuItem pushDown = new JMenuItem("Push Down...");

    menu.add(rename);
    menu.add(move);
    menu.add(copy);
    menu.add(safelyDelete);
    menu.addSeparator();
    menu.add(inlineItem);
    menu.add(changeParams);
    menu.addSeparator();
    menu.add(pullUp);
    menu.add(pushDown);

    menubar.add(menu);
    }

    private void initMenuRun() {
    JMenu menu = new JMenu("Run");

    JMenuItem runProject = new JMenuItem("Run Project (JavaSwing)");
    runProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));

    JMenuItem testProject = new JMenuItem("Test Project (JavaSwing)");
    testProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, InputEvent.ALT_DOWN_MASK));

    JMenuItem buildProject = new JMenuItem("Build Project (JavaSwing)");
    buildProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));

    JMenuItem cleanBuild = new JMenuItem("Clean and Build Project (JavaSwing)");
    cleanBuild.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, InputEvent.SHIFT_DOWN_MASK));

    JMenu setConfig = new JMenu("Set Project Configuration");
    JMenu setBrowser = new JMenu("Set Project Browser");
    JMenu setMain = new JMenu("Set Main Project");

    JMenuItem javaShell = new JMenuItem("Open Java Shell for Project (JavaSwing)");
    javaShell.setEnabled(false);

    menu.add(runProject);
    menu.add(testProject);
    menu.addSeparator();
    menu.add(buildProject);
    menu.add(cleanBuild);
    menu.addSeparator();
    menu.add(setConfig);
    menu.add(setBrowser);
    menu.add(setMain);
    menu.addSeparator();
    menu.add(javaShell);

    menubar.add(menu);
    }

    private void initMenuDebug(){
    JMenu menu = new JMenu("Debug");

    // ----
    ImageIcon icon = new ImageIcon("C:/Users/DucPc/Desktop/hai.jpg");
    icon = resizeImageIcon(icon, 16, 16);

    //-----
    JMenuItem debugProject = new JMenuItem("Debug Project (JavaSwing)", icon);
    debugProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_DOWN_MASK));
    menu.add(debugProject);

    // ----
    JMenuItem debugFile = new JMenuItem("Debug File", icon);
    debugFile.setAccelerator(KeyStroke.getKeyStroke(
            KeyEvent.VK_F5, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK
    ));
    menu.add(debugFile);

    // --------
    JMenuItem debugTestFile = new JMenuItem("Debug Test File");
    debugTestFile.setEnabled(false);
    menu.add(debugTestFile);
    menu.addSeparator();
    //--------
    JMenuItem attachDebugger = new JMenuItem("Attach Debugger...", icon);
    menu.add(attachDebugger);

    // ---------
    JMenuItem finishSession = new JMenuItem("Finish Debugger Session", icon);
    finishSession.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.SHIFT_DOWN_MASK));
    finishSession.setEnabled(false);
    menu.add(finishSession);
    menu.addSeparator();
    JMenuItem pause = new JMenuItem("Pause", icon);
    pause.setEnabled(false);
    menu.add(pause);
    JMenuItem cont = new JMenuItem("Continue", icon);
    cont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
    cont.setEnabled(false);
    menu.add(cont);
    menu.addSeparator();
    JMenuItem stepOver = new JMenuItem("Step Over", icon);
    stepOver.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
    menu.add(stepOver);
    JMenuItem stepOverExpr = new JMenuItem("Step Over Expression", icon);
    stepOverExpr.setAccelerator(KeyStroke.getKeyStroke(
            KeyEvent.VK_F8, InputEvent.SHIFT_DOWN_MASK
    ));
    menu.add(stepOverExpr);
    JMenuItem stepInto = new JMenuItem("Step Into", icon);
    stepInto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
    menu.add(stepInto);
    menubar.add(menu);
    }

    private void initMenuProfile() {
    JMenu menu = new JMenu("Profile");

    JMenuItem profileProject = new JMenuItem("Profile Project (JavaSwing)");
    profileProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_DOWN_MASK));

    JMenuItem profileFile = new JMenuItem("Profile File");
    JMenuItem profileTest = new JMenuItem("Profile Test File");
    profileTest.setEnabled(false);

    JMenuItem attachProject = new JMenuItem("Attach to Project (JavaSwing)");
    JMenuItem attachExternal = new JMenuItem("Attach to External Process");

    JMenuItem finishSession = new JMenuItem("Finish Profiler Session");
    finishSession.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.SHIFT_DOWN_MASK));
    finishSession.setEnabled(false);

    JMenuItem takeDump = new JMenuItem("Take Thread Dump");

    menu.add(profileProject);
    menu.add(profileFile);
    menu.add(profileTest);
    menu.addSeparator();
    menu.add(attachProject);
    menu.add(attachExternal);
    menu.addSeparator();
    menu.add(finishSession);
    menu.add(takeDump);

    menubar.add(menu);
}

   private void initMenuTeam() {
    JMenu menu = new JMenu("Team");

    JMenuItem showChanges = new JMenuItem("Show Changes");
    JMenu diffMenu = new JMenu("Diff");
    JMenuItem add = new JMenuItem("Add");
    JMenuItem commit = new JMenuItem("Commit...");
    JMenuItem checkout = new JMenuItem("Checkout");

    JMenuItem revert = new JMenuItem("Revert Modifications...");
    JMenuItem annotations = new JMenuItem("Show Annotations");
    annotations.setEnabled(false);

    JMenuItem history = new JMenuItem("Show History");
    JMenuItem resolveConflicts = new JMenuItem("Resolve Conflicts");
    resolveConflicts.setEnabled(false);

    JMenuItem ignore = new JMenuItem("Ignore");
    JMenuItem patches = new JMenuItem("Patches");

    menu.add(showChanges);
    menu.add(diffMenu);
    menu.add(add);
    menu.add(commit);
    menu.add(checkout);
    menu.add(revert);
    menu.add(annotations);
    menu.add(history);
    menu.add(resolveConflicts);
    menu.addSeparator();
    menu.add(ignore);
    menu.add(patches);

    menubar.add(menu);
}

    private void initMenuTools() {
    JMenu menu = new JMenu("Tools");

    JMenuItem applyPatch = new JMenuItem("Apply Diff Patch...");
    JMenuItem diff = new JMenuItem("Diff...");
    JMenuItem addFavorites = new JMenuItem("Add to Favorites");
    JMenuItem openSystem = new JMenuItem("Open in System");
    JMenuItem openTerminal = new JMenuItem("Open in Terminal");
    JMenuItem analyzeJavadoc = new JMenuItem("Analyze Javadoc");
    JMenuItem addPalette = new JMenuItem("Add to Palette...");

    JMenu testsMenu = new JMenu("Create/Update Tests");
    JMenu intlMenu = new JMenu("Internationalization");

    menu.add(applyPatch);
    menu.add(diff);
    menu.add(addFavorites);
    menu.add(openSystem);
    menu.add(openTerminal);
    menu.add(analyzeJavadoc);
    menu.add(addPalette);
    menu.add(testsMenu);
    menu.add(intlMenu);

    menubar.add(menu);
    }


    private void initMenuWindow() {
    JMenu menu = new JMenu("Window");

    JMenuItem itemProjects = new JMenuItem("Projects");
    JMenuItem itemFiles = new JMenuItem("Files");
    JMenuItem itemFavorites = new JMenuItem("Favorites");
    JMenuItem itemServices = new JMenuItem("Services");
    JMenuItem itemNavigator = new JMenuItem("Navigator");
    JMenuItem itemActionItems = new JMenuItem("Action Items");

    JMenuItem itemTasks = new JMenuItem("Tasks");
    itemTasks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));

    JMenuItem itemOutput = new JMenuItem("Output");
    JMenuItem itemEditor = new JMenuItem("Editor");
    JMenuItem itemCheckRegex = new JMenuItem("Check Regex");

    JMenu menuDebugging = new JMenu("Debugging");
    JMenu menuProfiling = new JMenu("Profiling");

    menu.add(itemProjects);
    menu.add(itemFiles);
    menu.add(itemFavorites);
    menu.add(itemServices);
    menu.add(itemNavigator);
    menu.add(itemActionItems);
    menu.add(itemTasks);

    menu.addSeparator();

    menu.add(itemOutput);
    menu.add(itemEditor);
    menu.add(itemCheckRegex);

    menu.addSeparator();

    menu.add(menuDebugging);
    menu.add(menuProfiling);

    menubar.add(menu);
}

    private void initMenuHelp() {
    JMenu menu = new JMenu("Help");

    JMenuItem itemOnlineDocs = new JMenuItem("Online Docs and Support");
    JMenuItem itemShortcuts = new JMenuItem("Keyboard Shortcuts Card");
    JMenuItem itemReportIssue = new JMenuItem("Report Issue");

    JMenuItem itemJavadocIndex = new JMenuItem("Javadoc Index Search");
    itemJavadocIndex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.SHIFT_DOWN_MASK));
    JMenu menuJavadocRefs = new JMenu("Javadoc References");

    JMenuItem itemCheckUpdates = new JMenuItem("Check for Updates");
    JMenuItem itemAbout = new JMenuItem("About");

    menu.add(itemOnlineDocs);
    menu.add(itemShortcuts);
    menu.add(itemReportIssue);

    menu.addSeparator();

    menu.add(itemJavadocIndex);
    menu.add(menuJavadocRefs);

    menu.addSeparator();

    menu.add(itemCheckUpdates);
    menu.add(itemAbout);

    menubar.add(menu);
    }



    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height){
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    
    private void initToolBar(){
    JToolBar toolBar = new JToolBar("Tool Bar");
    //-----
    ImageIcon newIcon = new ImageIcon("C:/Users/DucPc/Desktop/newfolder.png");
    newIcon = resizeImageIcon(newIcon, 20, 20);
    JButton btnNewFile = new JButton(newIcon);
    btnNewFile.setBorderPainted(false);
    btnNewFile.setToolTipText("New File...(Ctrl+N)");
    toolBar.add(btnNewFile);
    //----
    ImageIcon iconFolder = new ImageIcon("C:/Users/DucPc/Desktop/iconfolder.jpg");
    iconFolder = resizeImageIcon(iconFolder, 20, 20);
    JButton btniconFolder = new JButton(iconFolder);
    btniconFolder.setBorderPainted(false);
    btniconFolder.setToolTipText("New Project...(Ctrl+Shift+N)");
    toolBar.add(btniconFolder);
    //---
    ImageIcon iconPackage = new ImageIcon("C:/Users/DucPc/Desktop/iconpackage.jpg");
    iconPackage = resizeImageIcon(iconPackage, 20, 20);
    JButton btniconPackage = new JButton(iconPackage);
    btniconPackage.setBorderPainted(false);
    btniconPackage.setToolTipText("Open Project...(Ctrl+Shift+o)");
    toolBar.add(btniconPackage);
    //-----
    ImageIcon iconSave = new ImageIcon("C:/Users/DucPc/Desktop/iconsave.jpg");
    iconSave = resizeImageIcon(iconSave, 20, 20);
    JButton btniconSave = new JButton(iconSave);
    btniconSave.setBorderPainted(false);
    btniconSave.setToolTipText("Save All...(Ctrl+Shift+S)");
    toolBar.add(btniconSave);
    //-----
    ImageIcon iconUndo = new ImageIcon("C:/Users/DucPc/Desktop/undo.jpg");
    iconUndo = resizeImageIcon(iconUndo, 20, 20);
    JButton btniconUndo = new JButton(iconUndo);
    btniconUndo.setBorderPainted(false);
    btniconUndo.setToolTipText("Undo...(Ctrl+N)");
    toolBar.add(btniconUndo);
    //-----
    ImageIcon iconRedo = new ImageIcon("C:/Users/DucPc/Desktop/redo.jpg");
    iconRedo = resizeImageIcon(iconRedo, 20, 20);
    JButton btniconRedo = new JButton(iconRedo);
    btniconRedo.setBorderPainted(false);
    btniconRedo.setToolTipText("Redo...(Ctrl+N)");
    toolBar.add(btniconRedo);

    toolBar.addSeparator();
    // --------Jcombobox 
    String[] configs = { "<default config>", "Customize..." };
    JComboBox<String> combo = new JComboBox<>(configs);
    combo.setMaximumSize(new Dimension(150, 25));
    btniconRedo.setBorderPainted(false);
    toolBar.add(combo);
    
    toolBar.addSeparator();
    //trai dat
    ImageIcon iconTraiDat = new ImageIcon("C:/Users/DucPc/Desktop/traidat.jpg");
    iconTraiDat = resizeImageIcon(iconTraiDat, 20, 20);

    ImageIcon iconTDarrow = new ImageIcon("C:/Users/DucPc/Desktop/arrow_down_small.png");
    iconTDarrow = resizeImageIcon(iconTDarrow, 8, 8);
    JButton btnTraiDat = new JButton(iconTraiDat);
    btnTraiDat.setBorderPainted(false);
    btnTraiDat.setFocusPainted(false);
    btnTraiDat.setToolTipText("Build Project");
    toolBar.add(btnTraiDat);
    JButton btnArrow = new JButton(iconTDarrow);
    btnArrow.setBorderPainted(false);
    btnArrow.setFocusPainted(false);
    btnArrow.setToolTipText("Build Options");
    toolBar.add(btnArrow);
    // ---------------------
    ImageIcon iconBuildProject = new ImageIcon("C:/Users/DucPc/Desktop/buildpj.png");
    iconBuildProject = resizeImageIcon(iconBuildProject, 20, 20);

    JButton btnBuildProject = new JButton(iconBuildProject);
    btnBuildProject.setBorderPainted(false);
    btnBuildProject.setFocusPainted(false);
    btnBuildProject.setToolTipText("Build Project");
    toolBar.add(btnBuildProject);

    // ----------------------------------------
    ImageIcon iconCleanBuild = new ImageIcon("C:/Users/DucPc/Desktop/cleanbuildpj.png");
    iconCleanBuild = resizeImageIcon(iconCleanBuild, 20, 20);

    JButton btnCleanBuild = new JButton(iconCleanBuild);
    btnCleanBuild.setBorderPainted(false);
    btnCleanBuild.setFocusPainted(false);
    btnCleanBuild.setToolTipText("Clean and Build Project");
    toolBar.add(btnCleanBuild);

    // 
    ImageIcon iconRun = new ImageIcon("C:/Users/DucPc/Desktop/run.png");
    iconRun = resizeImageIcon(iconRun, 20, 20);
    JButton btnRun = new JButton(iconRun);
    btnRun.setBorderPainted(false);
    btnRun.setFocusPainted(false);
    btnRun.setToolTipText("Run Project");
    toolBar.add(btnRun);

    // Nút mũi tên
    ImageIcon iconRunArrow = new ImageIcon("C:/Users/DucPc/Desktop/arrow_down_small.png");
    iconRunArrow = resizeImageIcon(iconRunArrow, 8, 8);
    JButton btnRunArrow = new JButton(iconRunArrow);
    btnRunArrow.setBorderPainted(false);
    btnRunArrow.setFocusPainted(false);
    btnRunArrow.setToolTipText("Run Project Options");
    toolBar.add(btnRunArrow);
    
    //
    ImageIcon iconDebug = new ImageIcon("C:/Users/DucPc/Desktop/debug.png");
    iconDebug = resizeImageIcon(iconDebug, 20, 20);
    JButton btnRunFile = new JButton(iconDebug);
    btnRunFile.setBorderPainted(false);
    btnRunFile.setFocusPainted(false);
    btnRunFile.setToolTipText("Run File");
    toolBar.add(btnRunFile);

    // mũi tên
    JButton btnRunFileArrow = new JButton(iconRunArrow);
    btnRunFileArrow.setBorderPainted(false);
    btnRunFileArrow.setFocusPainted(false);
    btnRunFileArrow.setToolTipText("Run File Options");
    toolBar.add(btnRunFileArrow);

    //
    ImageIcon iconRunFocus = new ImageIcon("C:/Users/DucPc/Desktop/runfocused.png");
    iconRunFocus = resizeImageIcon(iconRunFocus, 20, 20);
    JButton btnRunFocus = new JButton(iconRunFocus);
    btnRunFocus.setBorderPainted(false);
    btnRunFocus.setFocusPainted(false);
    btnRunFocus.setToolTipText("Run Focused File");
    toolBar.add(btnRunFocus);

    JButton btnRunFocusArrow = new JButton(iconRunArrow);
    btnRunFocusArrow.setBorderPainted(false);
    btnRunFocusArrow.setFocusPainted(false);
    btnRunFocusArrow.setToolTipText("Run Focused Options");
    toolBar.add(btnRunFocusArrow);
    toolBar.addSeparator();
    //--
    ImageIcon iconProfile = new ImageIcon("C:/Users/DucPc/Desktop/profile_icon.png");
    iconProfile = resizeImageIcon(iconProfile, 20, 20);

    JButton btnProfile = new JButton(iconProfile);
    btnProfile.setBorderPainted(false);
    btnProfile.setFocusPainted(false);
    btnProfile.setToolTipText("Profile Project (JavaSwing)");
    toolBar.add(btnProfile);
    toolBar.addSeparator();
    //------
    ImageIcon iconAttach = new ImageIcon("C:/Users/DucPc/Desktop/attach_icon.png");
    iconAttach = resizeImageIcon(iconAttach, 20, 20);

    JButton btnAttach = new JButton(iconAttach);
    btnAttach.setBorderPainted(false);
    btnAttach.setFocusPainted(false);
    btnAttach.setToolTipText("Attach to External Process");
    toolBar.add(btnAttach);

    this.add(toolBar, BorderLayout.NORTH);
    

    }
    


}