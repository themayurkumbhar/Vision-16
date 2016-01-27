package com.mayur.kumbhar.vision;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mayur.kumbhar.vision.model.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class FragmentDrawer extends Fragment implements View.OnClickListener{

    private static String TAG = FragmentDrawer.class.getSimpleName();

    //private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter adapter;
    private View containerView;
    private static String[] titles = null;
    private FragmentDrawerListener drawerListener;

    public FragmentDrawer() {

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public static List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<>();


        // preparing navigation drawer items
        for (int i = 0; i < titles.length; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            data.add(navItem);
        }
        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // drawer labels
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
       // recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);

 /*       adapter = new NavigationDrawerAdapter(getActivity(), getData());
      //  recyclerView.setAdapter(adapter);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      //  recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
*/

        layout.findViewById(R.id.cyclick).setOnClickListener(this);
        layout.findViewById(R.id.exclick).setOnClickListener(this);
        layout.findViewById(R.id.ficlick).setOnClickListener(this);
        layout.findViewById(R.id.ipdclick).setOnClickListener(this);
        layout.findViewById(R.id.pcclick).setOnClickListener(this);
        layout.findViewById(R.id.roclick).setOnClickListener(this);
        layout.findViewById(R.id.reclick).setOnClickListener(this);
        layout.findViewById(R.id.teclick).setOnClickListener(this);
        layout.findViewById(R.id.expomenu).setOnClickListener(this);
        layout.findViewById(R.id.cybermenu).setOnClickListener(this);
        layout.findViewById(R.id.financemenu).setOnClickListener(this);
        layout.findViewById(R.id.robomenu).setOnClickListener(this);
        layout.findViewById(R.id.technomenu).setOnClickListener(this);
        layout.findViewById(R.id.refreshmentmenu).setOnClickListener(this);
        layout.findViewById(R.id.pressmenu).setOnClickListener(this);
        layout.findViewById(R.id.ipdmenu).setOnClickListener(this);
        return layout;
    }


    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    @Override
    public void onClick(View view) {
        int pos=0;
        switch (view.getId())
        {
            case R.id.cybermenu:
            case R.id.cyclick:
                pos=0;
                break;
            case  R.id.expomenu:
            case R.id.exclick:
                pos=1;
                break;
            case R.id.robomenu:
            case R.id.roclick:
                pos=2;
                break;
            case R.id.technomenu:
            case R.id.teclick:
                pos=3;
                break;
            case R.id.ipdmenu:
            case R.id.ipdclick:
                pos=4;
                break;
            case R.id.pressmenu:
            case R.id.pcclick:
                pos=5;
                break;
            case R.id.ficlick:
            case R.id.financemenu:
                pos=6;
                break;
            case R.id.refreshmentmenu:
            case R.id.reclick:
                pos=7;
                break;
        }
        drawerListener.onDrawerItemSelected(view,pos);
        mDrawerLayout.closeDrawer(containerView);
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }

    public interface FragmentDrawerListener {
         void onDrawerItemSelected(View view, int position);
    }
}